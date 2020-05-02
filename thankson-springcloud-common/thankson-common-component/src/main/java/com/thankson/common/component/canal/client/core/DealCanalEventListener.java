package com.thankson.common.component.canal.client.core;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.thankson.springcloud.common.components.canal.client.abstracts.option.AbstractDBOption;
import com.thankson.springcloud.common.components.canal.client.interfaces.CanalEventListener;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 处理 Canal 监听器
 */
@SuppressWarnings("all")
public class DealCanalEventListener implements CanalEventListener {

    /**
     * 头节点
     */
    private AbstractDBOption header;

    /**
     * 默认构造方法，必须传入链路
     */
    public DealCanalEventListener(AbstractDBOption... dbOptions) {
        AbstractDBOption tmp = null;
        for (AbstractDBOption dbOption : dbOptions) {
            if (tmp != null) {
                tmp.setNext(dbOption);
            } else {
                this.header = dbOption;
            }
            tmp = dbOption;
        }

    }

    public DealCanalEventListener(List<AbstractDBOption> dbOptions) {
        if (CollectionUtils.isEmpty(dbOptions)) {
            return;
        }
        AbstractDBOption tmp = null;
        for (AbstractDBOption dbOption : dbOptions) {
            if (tmp != null) {
                tmp.setNext(dbOption);
            } else {
                this.header = dbOption;
            }
            tmp = dbOption;
        }
    }

    /**
     * 处理数据库的操作
     *
     * @param destination canal 指令
     * @param schemaName  实例名称
     * @param tableName   表名称
     * @param rowChange   数据
     * @return
     */
    @Override
    public void onEvent(String destination, String schemaName, String tableName, CanalEntry.RowChange rowChange) {
        this.header.doChain(destination, schemaName, tableName, rowChange);
    }


}
