package com.github.davitavorah.exceptions.handler;

import com.github.davitavorah.exceptions.model.APIError;
import com.github.davitavorah.exceptions.model.InvalidSessionException;
import com.github.davitavorah.exceptions.model.enums.ExceptionType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class InvalidSessionExceptionHandler {

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(InvalidSessionException.class)
    public APIError handleResourceNotFoundException(InvalidSessionException exception) {
        return APIError.builder().message(exception.getMessage()).type(ExceptionType.INVALID_SESSION).build();
    }

}
