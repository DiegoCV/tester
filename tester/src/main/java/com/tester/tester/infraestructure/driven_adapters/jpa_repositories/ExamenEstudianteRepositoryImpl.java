package com.tester.tester.infraestructure.driven_adapters.jpa_repositories;

import com.tester.tester.domain.model.ExamenEstudiante;
import com.tester.tester.domain.model.gateway.ExamenEstudianteRepository;
import com.tester.tester.infraestructure.driven_adapters.jpa_repositories.entiry.examenestudiante.ExamenEstudianteEntity;
import com.tester.tester.infraestructure.driven_adapters.jpa_repositories.entiry.examenestudiante.ExamenEstudianteEntityRepository;
import com.tester.tester.infraestructure.driven_adapters.jpa_repositories.entiry.examenestudiante.ExamenEstudianteMapper;
import com.tester.tester.infraestructure.driven_adapters.jpa_repositories.helper.AdapterOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ExamenEstudianteRepositoryImpl extends AdapterOperations<ExamenEstudiante, ExamenEstudianteEntity, UUID,
        ExamenEstudianteEntityRepository> implements ExamenEstudianteRepository {

    @Autowired
    ExamenEstudianteMapper examenEstudianteMapper;

    public ExamenEstudianteRepositoryImpl(ExamenEstudianteEntityRepository repository, ExamenEstudianteMapper mapper) {
        super(repository, mapper);
    }
}
