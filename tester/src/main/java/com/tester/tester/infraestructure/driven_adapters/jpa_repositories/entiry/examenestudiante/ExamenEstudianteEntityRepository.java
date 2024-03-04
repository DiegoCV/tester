package com.tester.tester.infraestructure.driven_adapters.jpa_repositories.entiry.examenestudiante;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.UUID;

public interface ExamenEstudianteEntityRepository extends CrudRepository<ExamenEstudianteEntity, UUID>,
        QueryByExampleExecutor<ExamenEstudianteEntity> {
}
