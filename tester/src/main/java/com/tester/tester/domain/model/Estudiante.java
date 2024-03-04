package com.tester.tester.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
public class Estudiante {
    private UUID id;
    private String nombre;
    private int edad;
    private String ciudad;
    private String zonaHoraria;
    private LocalDateTime fechapresentacion;
}
