package com.tester.tester.infraestructure.driven_adapters.jpa_repositories;

import com.tester.tester.domain.model.Examen;
import com.tester.tester.domain.model.gateway.ExamenRepository;
import com.tester.tester.infraestructure.driven_adapters.jpa_repositories.entiry.examen.ExamenEntity;
import com.tester.tester.infraestructure.driven_adapters.jpa_repositories.entiry.examen.ExamenEntityRepository;
import com.tester.tester.infraestructure.driven_adapters.jpa_repositories.entiry.examen.ExamenMapper;
import com.tester.tester.infraestructure.driven_adapters.jpa_repositories.helper.AdapterOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class ExamenRepositoryImpl extends AdapterOperations<Examen, ExamenEntity, UUID, ExamenEntityRepository>
        implements ExamenRepository {

    @Autowired
    ExamenMapper examenMapper;

    public ExamenRepositoryImpl(ExamenEntityRepository repository, ExamenMapper mapper) {
        super(repository, mapper);
    }
}
