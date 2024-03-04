package com.tester.tester.infraestructure.driven_adapters.jpa_repositories;

import com.tester.tester.domain.model.Estudiante;
import com.tester.tester.domain.model.gateway.EstudianteRepository;
import com.tester.tester.infraestructure.driven_adapters.jpa_repositories.entiry.estudiante.EstudianteEntity;
import com.tester.tester.infraestructure.driven_adapters.jpa_repositories.entiry.estudiante.EstudianteEntityRepository;
import com.tester.tester.infraestructure.driven_adapters.jpa_repositories.entiry.estudiante.EstudianteMapper;
import com.tester.tester.infraestructure.driven_adapters.jpa_repositories.helper.AdapterOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class EstudianteRepositoryImpl extends AdapterOperations<Estudiante, EstudianteEntity, UUID,
        EstudianteEntityRepository> implements EstudianteRepository {

    @Autowired
    EstudianteMapper estudianteMapper;

    public EstudianteRepositoryImpl(EstudianteEntityRepository repository, EstudianteMapper mapper) {
        super(repository, mapper);
    }
}
