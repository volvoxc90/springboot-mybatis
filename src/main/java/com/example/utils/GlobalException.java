package com.example.utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhugp
 * @create 2018-04-23 17:41
 **/
@ControllerAdvice
public class GlobalException  {
    @ExceptionHandler
    @ResponseBody
    public String systemException(Exception ex) {
        if( ex instanceof Exception) {
            return ex.getClass().getName();
        }
        return ex.getClass().getName();
    }
}