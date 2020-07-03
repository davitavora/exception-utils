package com.github.davitavorah.exceptions.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DuplicatedEntityException extends RuntimeException {

    public DuplicatedEntityException(String message) {
        super(message);
    }

}