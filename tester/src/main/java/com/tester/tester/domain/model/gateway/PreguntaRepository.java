package com.tester.tester.domain.model.gateway;

import com.tester.tester.domain.model.Pregunta;

import java.util.List;
import java.util.UUID;

public interface PreguntaRepository {
    Pregunta save(Pregunta pregunta);
    List<Pregunta> findByExamenId(UUID examenId);
}
