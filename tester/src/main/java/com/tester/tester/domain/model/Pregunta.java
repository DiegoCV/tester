package com.tester.tester.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class Pregunta {
    private UUID id;
    private String enunciado;
    private String opcionA;
    private String opcionB;
    private String opcionC;
    private String opcionD;
    private String opcionCorrecta;
    private String opcionSeleccionada;
    private int puntos;
    private UUID examenId;
}
