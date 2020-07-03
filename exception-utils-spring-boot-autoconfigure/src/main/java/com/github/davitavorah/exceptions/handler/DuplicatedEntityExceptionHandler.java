package com.github.davitavorah.exceptions.handler;

import com.github.davitavorah.exceptions.model.APIError;
import com.github.davitavorah.exceptions.model.DuplicatedEntityException;
import com.github.davitavorah.exceptions.model.enums.ExceptionType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DuplicatedEntityExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DuplicatedEntityException.class)
    public APIError handleResourceNotFoundException(DuplicatedEntityException exception) {
        return APIError.builder().message(exception.getMessage()).type(ExceptionType.DUPLICATED_ENTITY).build();
    }

}
