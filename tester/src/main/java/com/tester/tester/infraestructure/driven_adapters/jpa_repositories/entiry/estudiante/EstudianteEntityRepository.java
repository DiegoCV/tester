package com.tester.tester.infraestructure.driven_adapters.jpa_repositories.entiry.estudiante;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.UUID;

public interface EstudianteEntityRepository extends CrudRepository<EstudianteEntity, UUID>,
        QueryByExampleExecutor<EstudianteEntity> {
}
