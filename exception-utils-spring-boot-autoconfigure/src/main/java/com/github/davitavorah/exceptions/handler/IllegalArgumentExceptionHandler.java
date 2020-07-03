package com.github.davitavorah.exceptions.handler;

import com.github.davitavorah.exceptions.model.APIError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class IllegalArgumentExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public APIError handleIllegalArgumentException(IllegalArgumentException exception) {
        return APIError.builder().message(exception.getMessage()).build();
    }

}
