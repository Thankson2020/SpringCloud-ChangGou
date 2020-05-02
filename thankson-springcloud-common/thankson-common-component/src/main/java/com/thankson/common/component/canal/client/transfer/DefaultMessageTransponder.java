package com.thankson.common.component.canal.client.transfer;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.thankson.springcloud.common.components.canal.annotation.ListenPoint;
import com.thankson.springcloud.common.components.canal.client.abstracts.AbstractBasicMessageTransponder;
import com.thankson.springcloud.common.components.canal.client.core.CanalMsg;
import com.thankson.springcloud.common.components.canal.client.core.ListenerPoint;
import com.thankson.springcloud.common.components.canal.client.interfaces.CanalEventListener;
import com.thankson.springcloud.common.components.canal.config.CanalConfig;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * 默认的信息转换器
 */
public class DefaultMessageTransponder extends AbstractBasicMessageTransponder {


    public DefaultMessageTransponder(CanalConnector connector, Map.Entry<String, CanalConfig.Instance> config, List<CanalEventListener> listeners, List<ListenerPoint> annoListeners) {
        super(connector, config, listeners, annoListeners);
    }


    /**
     * 断言注解方式的监听过滤规则
     *
     * @param destination 指令
     * @param schemaName  数据库实例
     * @param tableName   表名称
     * @param eventType   事件类型
     */
    @Override
    protected Predicate<Map.Entry<Method, ListenPoint>> getAnnotationFilter(String destination, String schemaName, String tableName, CanalEntry.EventType eventType) {
        //检查指令是否正确
        Predicate<Map.Entry<Method, ListenPoint>> df = e -> StringUtils.isEmpty(e.getValue().destination())
                || e.getValue().destination().equals(destination) || destination == null;

        //检查数据库实例名是否一致
        Predicate<Map.Entry<Method, ListenPoint>> sf = e -> e.getValue().schema().length == 0
                || Arrays.stream(e.getValue().schema()).anyMatch(s -> s.equals(schemaName)) || schemaName == null;

        //检查表名是否一致
        Predicate<Map.Entry<Method, ListenPoint>> tf = e -> e.getValue().table().length == 0
                || Arrays.stream(e.getValue().table()).anyMatch(t -> t.equals(tableName)) || tableName == null;

        //检查事件类型是否一致
        Predicate<Map.Entry<Method, ListenPoint>> ef = e -> e.getValue().eventType().length == 0
                || Arrays.stream(e.getValue().eventType()).anyMatch(ev -> ev == eventType) || eventType == null;

        return df.and(sf).and(tf).and(ef);
    }

    /**
     * 获取处理的参数
     *
     * @param method    监听的方法
     * @param canalMsg  事件节点
     * @param rowChange 详细参数
     */
    @Override
    protected Object[] getInvokeArgs(Method method, CanalMsg canalMsg, CanalEntry.RowChange rowChange) {
        return Arrays.stream(method.getParameterTypes())
                .map(p -> p == CanalMsg.class ? canalMsg : p == CanalEntry.RowChange.class ? rowChange : null)
                .filter(Objects::nonNull)
                .toArray();
    }

    @Override
    protected Object[] getInvokeArgs(Method method, CanalMsg canalMsg, CanalEntry.RowData rowData) {
        return Arrays.stream(method.getParameterTypes())
                .map(p -> p == CanalMsg.class ? canalMsg : p == CanalEntry.RowData.class ? rowData : null)
                .filter(Objects::nonNull)
                .toArray();
    }

    @Override
    protected Object[] getInvokeArgs(Method method,CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
        return Arrays.stream(method.getParameterTypes())
                .map(p -> p == CanalEntry.EventType.class ? eventType : p == CanalEntry.RowData.class ? rowData : null)
                .filter(Objects::nonNull)
                .toArray();
    }


    /**
     * 忽略实体类的类型
     */
    @Override
    protected List<CanalEntry.EntryType> getIgnoreEntryTypes() {
        return Arrays.asList(CanalEntry.EntryType.TRANSACTIONBEGIN, CanalEntry.EntryType.TRANSACTIONEND, CanalEntry.EntryType.HEARTBEAT);
    }
}
