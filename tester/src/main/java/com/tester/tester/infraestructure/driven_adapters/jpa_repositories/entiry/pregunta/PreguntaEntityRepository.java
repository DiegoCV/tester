package com.tester.tester.infraestructure.driven_adapters.jpa_repositories.entiry.pregunta;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;
import java.util.UUID;

public interface PreguntaEntityRepository extends CrudRepository<PreguntaEntity, UUID>,
        QueryByExampleExecutor<PreguntaEntity> {

    @Query("""
            select p from PreguntaEntity p                         
            where p.examenId = ?1            
            """
    )
    List<PreguntaEntity> findByExamenId(UUID examenId);
}
