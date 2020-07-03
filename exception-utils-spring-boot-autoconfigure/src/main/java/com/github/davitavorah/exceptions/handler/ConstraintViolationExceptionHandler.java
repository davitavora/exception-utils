package com.github.davitavorah.exceptions.handler;

import com.github.davitavorah.exceptions.model.APIError;
import com.github.davitavorah.exceptions.model.enums.ExceptionType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ConstraintViolationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public APIError handleResourceNotFoundException(ConstraintViolationException exception) {
        String constraintViolationMessages = exception.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(". "));
        return APIError.builder().message(constraintViolationMessages).type(ExceptionType.ERROR).build();
    }

}
