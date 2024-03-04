package com.tester.tester.infraestructure.driven_adapters.jpa_repositories.entiry.examen;

import com.tester.tester.domain.model.Examen;
import com.tester.tester.infraestructure.driven_adapters.jpa_repositories.helper.SimpleMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExamenMapper extends SimpleMapper<Examen, ExamenEntity> {
}
