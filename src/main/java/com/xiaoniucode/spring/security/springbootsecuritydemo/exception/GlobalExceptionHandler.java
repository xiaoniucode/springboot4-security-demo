package com.xiaoniucode.spring.security.springbootsecuritydemo.exception;

import com.xiaoniucode.spring.security.springbootsecuritydemo.common.Ajax;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public Ajax handleBusinessException(BusinessException e) {
        return Ajax.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Ajax handleException(Exception e) {
        e.printStackTrace();
        return Ajax.error("系统内部错误");
    }

}
