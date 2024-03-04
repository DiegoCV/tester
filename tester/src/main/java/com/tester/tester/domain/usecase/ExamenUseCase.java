package com.tester.tester.domain.usecase;

import com.tester.tester.domain.model.Estudiante;
import com.tester.tester.domain.model.Examen;

import java.util.List;

public interface ExamenUseCase {
    Examen crearExamen(Examen examen);

    int calificarExamen(Examen toExamen);

    void activarExamen(Examen examen);

    List<Estudiante> registrarEstudiantesExamen(Examen examen, List<Estudiante> collect);
}
