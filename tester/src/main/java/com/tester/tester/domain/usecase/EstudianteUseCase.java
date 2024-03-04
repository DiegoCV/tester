package com.tester.tester.domain.usecase;

import com.tester.tester.domain.model.Estudiante;

import java.util.UUID;

public interface EstudianteUseCase {
    Estudiante save(Estudiante estudiante);
    Estudiante findById(UUID estudianteId);
}
