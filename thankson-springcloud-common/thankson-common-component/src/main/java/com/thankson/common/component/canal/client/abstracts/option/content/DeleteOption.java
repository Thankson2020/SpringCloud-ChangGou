package com.thankson.common.component.canal.client.abstracts.option.content;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.thankson.springcloud.common.components.canal.client.abstracts.option.AbstractDBOption;

/**
 * 删除数据
 */

public abstract class DeleteOption extends AbstractDBOption {
    /**
     * 设置删除操作
     */
    @Override
    protected void setEventType() {
        this.eventType = CanalEntry.EventType.DELETE;
    }

}
