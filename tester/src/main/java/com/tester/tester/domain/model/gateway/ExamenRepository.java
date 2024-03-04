package com.tester.tester.domain.model.gateway;

import com.tester.tester.domain.model.Examen;

import java.util.UUID;

public interface ExamenRepository {
    Examen save(Examen examen);

    Examen findById(UUID id);
}
