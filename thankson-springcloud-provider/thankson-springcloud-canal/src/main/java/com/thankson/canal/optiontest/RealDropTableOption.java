package com.thankson.canal.optiontest;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.thankson.common.component.canal.client.abstracts.option.table.DropTableOption;
import org.springframework.stereotype.Component;

/**
 * 真正的删除表操作
 */
@Component
public class RealDropTableOption extends DropTableOption {

    /**
     * 删除表操作
     *
     * @param destination 指令
     * @param schemaName  实例名称
     * @param tableName   表名称
     * @param rowChange   数据
     */
    @Override
    public void doOption(String destination, String schemaName, String tableName, CanalEntry.RowChange rowChange) {
        System.out.println("======================接口方式（删除表操作）==========================");
        System.out.println("use " + schemaName + ";\n" + rowChange.getSql());
        System.out.println("\n======================================================");

    }
}
