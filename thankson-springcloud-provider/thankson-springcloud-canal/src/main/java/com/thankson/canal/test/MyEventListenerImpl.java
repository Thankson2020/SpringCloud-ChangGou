package com.thankson.canal.test;

import com.thankson.common.component.canal.client.abstracts.option.content.DeleteOption;
import com.thankson.common.component.canal.client.abstracts.option.content.InsertOption;
import com.thankson.common.component.canal.client.abstracts.option.content.UpdateOption;
import com.thankson.common.component.canal.client.core.DealCanalEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 实现接口方式测试
 */
//@Component
public class MyEventListenerImpl extends DealCanalEventListener {

    @Autowired
    public MyEventListenerImpl(@Qualifier("realInsertOption") InsertOption insertOption, @Qualifier("realDeleteOption") DeleteOption deleteOption, @Qualifier("realUpdateOption") UpdateOption updateOption) {
        super(insertOption, deleteOption, updateOption);
    }

}
