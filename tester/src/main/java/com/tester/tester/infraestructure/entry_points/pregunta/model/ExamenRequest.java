package com.tester.tester.infraestructure.entry_points.pregunta.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Getter
public class ExamenRequest {
    private UUID id;
    private List<PreguntaRequest> preguntas;
}
