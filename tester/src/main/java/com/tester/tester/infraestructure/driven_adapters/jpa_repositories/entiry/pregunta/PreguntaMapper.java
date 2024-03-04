package com.tester.tester.infraestructure.driven_adapters.jpa_repositories.entiry.pregunta;

import com.tester.tester.domain.model.Pregunta;
import com.tester.tester.infraestructure.driven_adapters.jpa_repositories.helper.SimpleMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PreguntaMapper extends SimpleMapper<Pregunta, PreguntaEntity> {
}
