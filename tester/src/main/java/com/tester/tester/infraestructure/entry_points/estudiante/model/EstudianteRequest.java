package com.tester.tester.infraestructure.entry_points.estudiante.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class EstudianteRequest {
    private String nombre;
    private int edad;
    private String ciudad;
    private String zonaHoraria;
}
