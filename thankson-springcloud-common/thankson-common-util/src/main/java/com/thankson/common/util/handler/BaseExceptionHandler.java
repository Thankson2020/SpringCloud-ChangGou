package com.thankson.common.util.handler;


import com.thankson.common.util.business.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.Objects;

/**
 * 异常处理
 *
 * @author Thankson
 * @date 2020年5月5日
 */
@RestControllerAdvice
public class BaseExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        logger.error(e.getMessage(), e);
        return new Result<>(false, 500, Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
    }

    @ExceptionHandler(ValidationException.class)
    public Result<Object> handleValidationException(ValidationException e) {
        logger.error(e.getMessage(), e);
        return new Result<>(false, 500, e.getCause().getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public Result<Object> handleConstraintViolationException(ConstraintViolationException e) {
        logger.error(e.getMessage(), e);
        return new Result<>(false, 500, e.getMessage());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public Result<Object> handlerNoFoundException(Exception e) {
        logger.error(e.getMessage(), e);
        return new Result<>(false, 404, "路径不存在，请检查路径是否正确");
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public Result<Object> handleDuplicateKeyException(DuplicateKeyException e) {
        logger.error(e.getMessage(), e);
        return new Result<>(false, 500, "数据重复，请检查后提交");
    }


    @ExceptionHandler(Exception.class)
    public Result<Object> handleException(Exception e) {
        logger.error(e.getMessage(), e);
        return new Result<>(false, 500, "系统繁忙,请稍后再试");
    }

}
