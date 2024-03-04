package com.tester.tester.infraestructure.driven_adapters.jpa_repositories.entiry.examen;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.UUID;

public interface ExamenEntityRepository extends CrudRepository<ExamenEntity, UUID>,
        QueryByExampleExecutor<ExamenEntity> {
}
