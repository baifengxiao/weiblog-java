package com.this0.blog.exception;

import com.this0.blog.utils.Result;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BlogExceptionHandler {

    public Result exHandle(Exception  e){
        e.printStackTrace();
        return Result.fail().message(e.getMessage());
    }
}
