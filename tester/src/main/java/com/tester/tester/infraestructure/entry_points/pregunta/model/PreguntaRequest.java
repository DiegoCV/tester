package com.tester.tester.infraestructure.entry_points.pregunta.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class PreguntaRequest {
     private UUID id;
     private String opcionSeleccionada;
}
