package com.tester.tester.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
public class Examen {
    private UUID id;
    private String titulo;
    private List<Pregunta> preguntas;
    private LocalDateTime fechapresentacion;
}
