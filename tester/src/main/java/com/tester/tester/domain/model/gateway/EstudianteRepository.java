package com.tester.tester.domain.model.gateway;

import com.tester.tester.domain.model.Estudiante;

import java.util.UUID;

public interface EstudianteRepository {
    Estudiante save(Estudiante estudiante);

    Estudiante findById(UUID estudianteId);
}
