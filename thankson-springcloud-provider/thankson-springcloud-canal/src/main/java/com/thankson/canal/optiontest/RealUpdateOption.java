package com.thankson.canal.optiontest;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.thankson.common.component.canal.client.abstracts.option.content.UpdateOption;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 需要自己实现的更新处理机制
 */
@Component
public class RealUpdateOption extends UpdateOption {

    /**
     * 更新数据操作
     *
     * @param destination 指令
     * @param schemaName  实例名称
     * @param tableName   表名称
     * @param rowChange   数据
     */
    @Override
    public void doOption(String destination, String schemaName, String tableName, CanalEntry.RowChange rowChange) {
        System.out.println("======================接口方式（更新数据操作）==========================");
        List<CanalEntry.RowData> rowDatasList = rowChange.getRowDatasList();
        for (CanalEntry.RowData rowData : rowDatasList) {
            String sql = "use " + schemaName + ";\n";
            StringBuffer updates = new StringBuffer();
            StringBuffer conditions = new StringBuffer();
            rowData.getAfterColumnsList().forEach((c) -> {
                if (c.getIsKey()) {
                    conditions.append(c.getName()).append("='").append(c.getValue()).append("'");
                } else {
                    updates.append(c.getName()).append("='").append(c.getValue()).append("',");
                }
            });
            sql += "UPDATE " + tableName + " SET " + updates.substring(0, updates.length() - 1) + " WHERE " + conditions;

            System.out.println(sql);
        }
        System.out.println("\n======================================================");
    }
}
