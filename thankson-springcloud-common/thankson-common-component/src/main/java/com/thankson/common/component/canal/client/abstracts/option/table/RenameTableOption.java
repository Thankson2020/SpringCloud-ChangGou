package com.thankson.common.component.canal.client.abstracts.option.table;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.thankson.common.component.canal.client.abstracts.option.AbstractDBOption;

/**
 * 重命名表名稱操作
 */
public abstract class RenameTableOption extends AbstractDBOption {

    /**
     * 重命名表操作
     */
    @Override
    protected void setEventType() {
        this.eventType = CanalEntry.EventType.RENAME;
    }
}
