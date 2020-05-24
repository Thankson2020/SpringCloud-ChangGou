package com.thankson.canal.optiontest;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.thankson.common.component.canal.client.abstracts.option.content.InsertOption;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 需要自己实现的新增处理机制
 */
@Component
public class RealInsertOption extends InsertOption {

    /**
     * 新增数据操作
     *
     * @param destination 指令
     * @param schemaName  实例名称
     * @param tableName   表名称
     * @param rowChange   数据
     */
    @Override
    public void doOption(String destination, String schemaName, String tableName, CanalEntry.RowChange rowChange) {
        System.out.println("======================接口方式（新增数据操作）==========================");
        List<CanalEntry.RowData> rowDataList = rowChange.getRowDatasList();
        for (CanalEntry.RowData rowData : rowDataList) {
            String sql = "use " + schemaName + ";\n";
            StringBuffer colums = new StringBuffer();
            StringBuffer values = new StringBuffer();
            rowData.getAfterColumnsList().forEach((c) -> {
                colums.append(c.getName()).append(",");
                values.append("'").append(c.getValue()).append("',");
            });
            sql += "INSERT INTO " + tableName + "(" + colums.substring(0, colums.length() - 1) + ") VALUES(" + values.substring(0, values.length() - 1) + ");";
            System.out.println(sql);
        }
        System.out.println("\n======================================================");
    }
}
