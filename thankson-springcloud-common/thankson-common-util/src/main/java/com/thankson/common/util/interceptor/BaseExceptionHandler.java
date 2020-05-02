package com.thankson.common.util.interceptor;


import com.thankson.common.util.business.Result;
import com.thankson.common.util.constant.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常处理
 *
 * @author Thankson
 * @date 2020年2月20日
 */
//交给spring容器管理 标识是一个异常处理器
@ControllerAdvice
public class BaseExceptionHandler {

    /*
     * 方法当被@requestMaping注解修饰的方法 有 异常发生的时候 被调用
     * Exception.class 当  发生了 Exception 异常以及它的子类的异常都被捕获到处理.
     *
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handlerException(Exception e) {
        e.printStackTrace();
        return new Result(false, StatusCode.ERROR, e.getMessage());
    }

}
