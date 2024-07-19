package com.abctechnologies.procurementmanagementsystem.exception;

import com.abctechnologies.procurementmanagementsystem.pojo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Result> handleException(Exception ex) {
        // Log the exception
        logger.error("Unexpected error occurred: {}", ex.getMessage(), ex);

        // Create a custom error response
        Result errorResponse = Result.error("An unexpected error occurred, please contact the administrator");

        // Return the response entity with HTTP status
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}