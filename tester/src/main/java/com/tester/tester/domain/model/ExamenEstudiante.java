package com.tester.tester.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Getter
@Setter
public class ExamenEstudiante {
    private UUID id;
    private UUID examenId;
    private UUID estudianteId;
}
