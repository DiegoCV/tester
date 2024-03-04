package com.tester.tester.infraestructure.driven_adapters.jpa_repositories;

import com.tester.tester.domain.model.Pregunta;
import com.tester.tester.domain.model.gateway.PreguntaRepository;
import com.tester.tester.infraestructure.driven_adapters.jpa_repositories.entiry.pregunta.PreguntaEntity;
import com.tester.tester.infraestructure.driven_adapters.jpa_repositories.entiry.pregunta.PreguntaEntityRepository;
import com.tester.tester.infraestructure.driven_adapters.jpa_repositories.entiry.pregunta.PreguntaMapper;
import com.tester.tester.infraestructure.driven_adapters.jpa_repositories.helper.AdapterOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class PreguntaRepositoryImpl extends AdapterOperations<Pregunta, PreguntaEntity, UUID, PreguntaEntityRepository>
        implements PreguntaRepository {

    @Autowired
    PreguntaMapper preguntaMapper;

    public PreguntaRepositoryImpl(PreguntaEntityRepository repository, PreguntaMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public List<Pregunta> findByExamenId(UUID examenId) {
        return repository.findByExamenId(examenId).stream().map(preguntaEntity -> {
            return preguntaMapper.toEntity(preguntaEntity);
        }).collect(Collectors.toList());
    }
}
