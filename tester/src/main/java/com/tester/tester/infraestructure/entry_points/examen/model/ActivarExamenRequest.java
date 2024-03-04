package com.tester.tester.infraestructure.entry_points.examen.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ActivarExamenRequest {
    private String fecha;
    private List<EstudianteRequest> estudiantes;
}
