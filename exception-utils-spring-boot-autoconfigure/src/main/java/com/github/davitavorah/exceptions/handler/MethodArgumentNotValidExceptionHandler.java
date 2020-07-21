package com.github.davitavorah.exceptions.handler;

import com.github.davitavorah.exceptions.model.APIError;
import com.github.davitavorah.exceptions.model.enums.ExceptionType;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class MethodArgumentNotValidExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public APIError handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        String constraintViolationMessages = exception.getBindingResult().getAllErrors()
                .stream()
                .map(error -> String.join(": ", ((FieldError) error).getField(), error.getDefaultMessage()))
                .collect(Collectors.joining(". "));
        return APIError.builder().message(constraintViolationMessages).type(ExceptionType.ERROR).build();
    }

}
