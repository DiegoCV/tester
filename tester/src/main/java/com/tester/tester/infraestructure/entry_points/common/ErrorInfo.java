package com.tester.tester.infraestructure.entry_points.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorInfo {
    @JsonProperty("mensaje")
    private String mensaje;
}