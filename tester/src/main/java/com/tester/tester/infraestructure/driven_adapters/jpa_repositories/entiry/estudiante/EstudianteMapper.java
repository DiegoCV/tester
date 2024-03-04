package com.tester.tester.infraestructure.driven_adapters.jpa_repositories.entiry.estudiante;

import com.tester.tester.domain.model.Estudiante;
import com.tester.tester.infraestructure.driven_adapters.jpa_repositories.helper.SimpleMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EstudianteMapper extends SimpleMapper<Estudiante, EstudianteEntity> {
}
