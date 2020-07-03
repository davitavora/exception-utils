package com.github.davitavorah.exceptions.model.enums;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ExceptionType {

    ERROR("error"),
    DUPLICATED_ENTITY("duplicatedEntity"),
    INVALID_SESSION("invalidSession");

    @Getter(onMethod = @__(@JsonValue))
    @JsonProperty("value")
    private String value;

}