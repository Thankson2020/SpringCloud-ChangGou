package com.thankson.canal.listener;

import com.alibaba.fastjson.JSON;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.thankson.common.component.canal.annotation.CanalEventListener;
import com.thankson.common.component.canal.annotation.ListenPoint;
import com.thankson.common.util.business.Result;
import com.thankson.mall.advert.feign.AdvertFeign;
import com.thankson.mall.advert.pojo.Advert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;


@CanalEventListener
public class CanalDataEventListener {

    @Autowired
    private AdvertFeign advertFeign;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @ListenPoint(destination = "example",
            schema = "changgou_advert",
            table = {"tb_advert", "tb_advert_category"},
            eventType = {
                    CanalEntry.EventType.UPDATE,
                    CanalEntry.EventType.DELETE,
                    CanalEntry.EventType.INSERT})
    public void onEventCustomUpdate(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
        //1.获取列名 为category_id的值
        String categoryId = getColumnValue(eventType, rowData);
        //2.调用feign 获取该分类下的所有的广告集合
        Result<List<Advert>> categoryResult = advertFeign.findByCategory(Integer.valueOf(categoryId));
        List<Advert> data = categoryResult.getData();
        for (Advert datum : data) {
            System.out.println(datum);
        }
        //3.使用redisTemplate存储到redis中
        stringRedisTemplate.boundValueOps("advert_" + categoryId).set(JSON.toJSONString(data));
    }

    private String getColumnValue(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
        String categoryId = "";
        //判断 如果是删除  则获取BeforeColumnsList
        if (eventType == CanalEntry.EventType.DELETE) {
            for (CanalEntry.Column column : rowData.getBeforeColumnsList()) {
                if (column.getName().equalsIgnoreCase("category_id")) {
                    categoryId = column.getValue();
                    return categoryId;
                }
            }
        } else {
            //判断 如果是添加 或者是更新 获取AfterColumnsList
            for (CanalEntry.Column column : rowData.getAfterColumnsList()) {
                if (column.getName().equalsIgnoreCase("category_id")) {
                    categoryId = column.getValue();
                    return categoryId;
                }
            }
        }
        return categoryId;
    }
}
