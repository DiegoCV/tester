package com.tester.tester.domain.usecase;

import com.tester.tester.domain.model.Pregunta;
import com.tester.tester.domain.model.gateway.PreguntaRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
public class PreguntaUseCaseImpl implements PreguntaUseCase{

    private final PreguntaRepository preguntaRepository;

    @Override
    public int calificarPreguntas(Map<UUID, Pregunta> preguntasOrg, List<Pregunta> preguntasRta) {
        return preguntasRta.stream().map(pregunta -> {
            return obtenerPuntos(preguntasOrg.get(pregunta.getId()), pregunta);
        }).reduce(0, Integer::sum);
    }

    @Override
    public List<Pregunta> save(List<Pregunta> preguntas) {
        return preguntas.stream().map(pregunta -> preguntaRepository.save(pregunta))
                .collect(Collectors.toList());
    }

    @Override
    public List<Pregunta> findByExamenId(UUID examenId) {
        return preguntaRepository.findByExamenId(examenId);
    }

    private int obtenerPuntos(Pregunta preguntaOriginal ,Pregunta preguntaRta){
        int calificacion = 0;
        if (preguntaOriginal.getOpcionCorrecta().equals(preguntaRta.getOpcionSeleccionada())){
            calificacion = preguntaOriginal.getPuntos();
        }

        return calificacion;
    }
}
