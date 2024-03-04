package com.tester.tester.infraestructure.driven_adapters.jpa_repositories.entiry.examenestudiante;

import com.tester.tester.domain.model.ExamenEstudiante;
import com.tester.tester.infraestructure.driven_adapters.jpa_repositories.helper.SimpleMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExamenEstudianteMapper extends SimpleMapper<ExamenEstudiante, ExamenEstudianteEntity> {
}
