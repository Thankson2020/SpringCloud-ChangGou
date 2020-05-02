package com.thankson.common.component.canal.client.abstracts;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.alibaba.otter.canal.protocol.Message;
import com.thankson.springcloud.common.components.canal.annotation.ListenPoint;
import com.thankson.springcloud.common.components.canal.client.core.CanalMsg;
import com.thankson.springcloud.common.components.canal.client.core.ListenerPoint;
import com.thankson.springcloud.common.components.canal.client.exception.CanalClientException;
import com.thankson.springcloud.common.components.canal.client.interfaces.CanalEventListener;
import com.thankson.springcloud.common.components.canal.config.CanalConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**
 * 消息处理转换类
 */
public abstract class AbstractBasicMessageTransponder extends AbstractMessageTransponder {
    /**
     * 日志记录
     */
    private final static Logger logger = LoggerFactory.getLogger(AbstractBasicMessageTransponder.class);

    /**
     * @param connector     canal 连接器
     * @param config        canal 连接配置
     * @param listeners     实现接口层的 canal 监听器
     * @param annoListeners 通过注解方式的 canal 监听器
     */
    public AbstractBasicMessageTransponder(CanalConnector connector, Map.Entry<String, CanalConfig.Instance> config, List<CanalEventListener> listeners, List<ListenerPoint> annoListeners) {
        super(connector, config, listeners, annoListeners);
    }

    /**
     * 处理消息
     */
    @Override
    protected void distributeEvent(Message message) {
        //获取操作实体
        List<CanalEntry.Entry> entries = message.getEntries();
        //遍历实体
        for (CanalEntry.Entry entry : entries) {
            //忽略实体类的类型
            List<CanalEntry.EntryType> ignoreEntryTypes = getIgnoreEntryTypes();
            if (ignoreEntryTypes != null && ignoreEntryTypes.stream().anyMatch(t -> entry.getEntryType() == t)) {
                continue;
            }
            //canal 改变信息
            CanalEntry.RowChange rowChange;
            try {
                //获取信息改变
                rowChange = CanalEntry.RowChange.parseFrom(entry.getStoreValue());

            } catch (Exception e) {
                throw new CanalClientException("错误 ##转换错误 , 数据信息:" + entry.toString(), e);
            }
            //如果是DDL语句 那么先什么也别做了 后续在考虑怎么处理
            if (rowChange.hasIsDdl() && rowChange.getIsDdl()) {
                continue;
            }
            //如果是SELECT语句 那么先什么也别做了 后续在考虑怎么处理
            if (rowChange.getEventType() == CanalEntry.EventType.QUERY) {
                continue;
            }
            //通过注解的方式
            distributeByAnnotation(destination,
                    entry.getHeader().getSchemaName(),
                    entry.getHeader().getTableName(),
                    rowChange);
            //通过接口的方式
            distributeByImpl(destination,
                    entry.getHeader().getSchemaName(),
                    entry.getHeader().getTableName(),
                    rowChange);

        }
    }

    /**
     * 处理注解方式的 canal 监听器
     *
     * @param destination canal 指令
     * @param schemaName  实例名称
     * @param tableName   表名称
     * @param rowChange   数据
     */
    protected void distributeByAnnotation(String destination,
                                          String schemaName,
                                          String tableName,
                                          CanalEntry.RowChange rowChange) {

        //对注解的监听器进行事件委托
        if (!CollectionUtils.isEmpty(annoListeners)) {
            annoListeners.forEach(point -> point
                    .getInvokeMap()
                    .entrySet()
                    .stream()
                    .filter(getAnnotationFilter(destination, schemaName, tableName, rowChange.getEventType()))
                    .forEach(entry -> {
                        Method method = entry.getKey();
                        method.setAccessible(true);
                        try {
                            CanalMsg canalMsg = new CanalMsg();
                            canalMsg.setDestination(destination);
                            canalMsg.setSchemaName(schemaName);
                            canalMsg.setTableName(tableName);
                            Object[] args = getInvokeArgs(method, canalMsg, rowChange);
                            if (method.getParameterTypes().length == args.length) {
                                method.invoke(point.getTarget(), args);
                            }
                            for (CanalEntry.RowData rowData : rowChange.getRowDatasList()) {
                                args = getInvokeArgs(method, canalMsg, rowData);
                                if (method.getParameterTypes().length == args.length) {
                                    method.invoke(point.getTarget(), args);
                                }
                                args = getInvokeArgs(method, rowChange.getEventType(), rowData);
                                if (method.getParameterTypes().length == args.length) {
                                    method.invoke(point.getTarget(), args);
                                }
                            }
                        } catch (Exception e) {
                            logger.error("{}: 委托 canal 监听器发生错误! 错误类:{}, 方法名:{}, 错误信息:{}",
                                    Thread.currentThread().getName(),
                                    point.getTarget().getClass().getName(), method.getName(),e.toString());
                        }
                    }));
        }
    }


    /**
     * 处理监听信息
     *
     * @param destination 指令
     * @param schemaName  库实例
     * @param tableName   表名
     * @param rowChange   參數
     */
    protected void distributeByImpl(String destination,
                                    String schemaName,
                                    String tableName,
                                    CanalEntry.RowChange rowChange) {
        if (listeners != null) {
            for (CanalEventListener listener : listeners) {
                listener.onEvent(destination, schemaName, tableName, rowChange);
            }
        }
    }


    /**
     * 断言注解方式的监听过滤规则
     *
     * @param destination 指定
     * @param schemaName  数据库实例
     * @param tableName   表名称
     * @param eventType   事件类型
     */
    protected abstract Predicate<Map.Entry<Method, ListenPoint>> getAnnotationFilter(String destination, String schemaName, String tableName, CanalEntry.EventType eventType);


    /**
     * 获取参数
     *
     * @param method    委托处理的方法
     * @param canalMsg  其他信息
     * @param rowChange 处理的数据
     */
    protected abstract Object[] getInvokeArgs(Method method, CanalMsg canalMsg, CanalEntry.RowChange rowChange);

    protected abstract Object[] getInvokeArgs(Method method, CanalMsg canalMsg, CanalEntry.RowData rowData);

    protected abstract Object[] getInvokeArgs(Method method, CanalEntry.EventType eventType, CanalEntry.RowData rowData);


    /**
     * 返回一个空集合
     */
    protected List<CanalEntry.EntryType> getIgnoreEntryTypes() {
        return Collections.emptyList();
    }

}
