package com.tester.tester.domain.usecase;

import com.tester.tester.domain.model.Pregunta;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface PreguntaUseCase {
    int calificarPreguntas(Map<UUID, Pregunta> preguntasOrg, List<Pregunta> preguntas);
    List<Pregunta> save(List<Pregunta> preguntas);
    List<Pregunta> findByExamenId(UUID examenId);
}
