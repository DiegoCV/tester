package com.tester.tester.application.config;

import com.tester.tester.domain.model.gateway.EstudianteRepository;
import com.tester.tester.domain.model.gateway.ExamenEstudianteRepository;
import com.tester.tester.domain.model.gateway.ExamenRepository;
import com.tester.tester.domain.model.gateway.PreguntaRepository;
import com.tester.tester.domain.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public PreguntaUseCase preguntaUseCase(PreguntaRepository preguntaRepository){
        return new PreguntaUseCaseImpl(preguntaRepository);
    }

    @Bean
    public ExamenUseCase examenUseCase(ExamenRepository examenRepository,
                                       PreguntaUseCase preguntaUseCase,
                                       EstudianteUseCase estudianteUseCase,
                                       ExamenEstudianteRepository examenEstudianteRepository){
        return new ExamenUseCaseImpl(examenRepository, preguntaUseCase, estudianteUseCase, examenEstudianteRepository);
    }

    @Bean
    public EstudianteUseCase estudianteUseCase(EstudianteRepository estudianteRepository){
        return new EstudianteUseCaseImpl(estudianteRepository);
    }

}
