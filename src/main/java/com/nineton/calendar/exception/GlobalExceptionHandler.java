package com.nineton.calendar.exception;

import com.nineton.calendar.pojo.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public Result jsonErrorHandler(RuntimeException e, HttpServletResponse response) throws Exception {
        return Result.build(500,"服务器内部错误",e);
    }
}


