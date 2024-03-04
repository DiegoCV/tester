package com.tester.tester.infraestructure.entry_points.examen.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EstudianteRequest {
    private String id;

    @JsonCreator
    public EstudianteRequest(@JsonProperty("id") String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
