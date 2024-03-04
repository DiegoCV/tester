package com.tester.tester.domain.usecase;

import com.tester.tester.domain.model.Estudiante;
import com.tester.tester.domain.model.common.EstudianteException;
import com.tester.tester.domain.model.gateway.EstudianteRepository;
import lombok.AllArgsConstructor;

import java.util.UUID;

import static com.tester.tester.domain.model.common.Constantes.ESTUDIANTE_NO_EXISTE;

@AllArgsConstructor
public class EstudianteUseCaseImpl implements EstudianteUseCase{

    private final EstudianteRepository estudianteRepository;

    @Override
    public Estudiante save(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public Estudiante findById(UUID estudianteId) {
        Estudiante estudiante = estudianteRepository.findById(estudianteId);
        if(estudiante == null){
            throw new EstudianteException(ESTUDIANTE_NO_EXISTE);
        }
        return estudiante;
    }
}
