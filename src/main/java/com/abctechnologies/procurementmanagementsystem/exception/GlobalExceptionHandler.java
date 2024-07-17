package com.abctechnologies.procurementmanagementsystem.exception;

import com.abctechnologies.procurementmanagementsystem.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result ex(Exception ex) {
        ex.printStackTrace();
        return Result.error("An unexpected error occurred, please contact the administrator");


    }
}
