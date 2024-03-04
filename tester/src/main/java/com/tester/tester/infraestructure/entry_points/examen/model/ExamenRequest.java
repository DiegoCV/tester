package com.tester.tester.infraestructure.entry_points.examen.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ExamenRequest {
    private String titulo;
    private List<PreguntaRequest> preguntas;
}
