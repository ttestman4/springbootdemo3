package com.example.demo3;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
public @Data class Quote {
    private String type;
    private Value value;
}
