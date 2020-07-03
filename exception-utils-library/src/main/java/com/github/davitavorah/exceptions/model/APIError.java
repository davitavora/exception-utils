package com.github.davitavorah.exceptions.model;

import com.github.davitavorah.exceptions.model.enums.ExceptionType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
public class APIError {

    @JsonProperty("mensagem")
    public final String message;

    @JsonProperty("tipo")
    public final ExceptionType type;

}
