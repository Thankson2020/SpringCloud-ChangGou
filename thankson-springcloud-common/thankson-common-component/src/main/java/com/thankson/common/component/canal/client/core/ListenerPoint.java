package com.thankson.common.component.canal.client.core;

import com.thankson.common.component.canal.annotation.ListenPoint;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 监听 canal 操作
 */
public class ListenerPoint {
    /**
     * 目标
     */
    private final Object target;

    /**
     * 监听的方法和节点
     */
    private final Map<Method, ListenPoint> invokeMap = new HashMap<>();

    /**
     * 构造方法，设置目标，方法以及注解类型
     *
     * @param target 目标
     * @param method 方法
     * @param anno   注解类型
     */
    ListenerPoint(Object target, Method method, ListenPoint anno) {
        this.target = target;
        this.invokeMap.put(method, anno);
    }

    /**
     * 返回目标类
     */
    public Object getTarget() {
        return target;
    }

    /**
     * 获取监听的操作方法和节点
     */
    public Map<Method, ListenPoint> getInvokeMap() {
        return invokeMap;
    }
}
