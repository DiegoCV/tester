package com.tester.tester.domain.usecase;

import com.tester.tester.domain.model.Estudiante;
import com.tester.tester.domain.model.Examen;
import com.tester.tester.domain.model.ExamenEstudiante;
import com.tester.tester.domain.model.Pregunta;
import com.tester.tester.domain.model.common.ExamenException;
import com.tester.tester.domain.model.gateway.ExamenEstudianteRepository;
import com.tester.tester.domain.model.gateway.ExamenRepository;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.tester.tester.domain.model.common.Constantes.*;

@AllArgsConstructor
public class ExamenUseCaseImpl implements ExamenUseCase{

    private final ExamenRepository examenRepository;
    private final PreguntaUseCase preguntaUseCase;
    private final EstudianteUseCase estudianteUseCase;
    private final ExamenEstudianteRepository examenEstudianteRepository;

    @Override
    public Examen crearExamen(Examen examen) {
        validarSumaTotalDePuntos(examen.getPreguntas());
        Examen save = examenRepository.save(Examen.builder().titulo(examen.getTitulo()).build());
        for(Pregunta pregunta: examen.getPreguntas()){
            pregunta.setExamenId(save.getId());
        }
        List<Pregunta> preguntas = preguntaUseCase.save(examen.getPreguntas());
        save.setPreguntas(preguntas);
        return save;
    }

    @Override
    public int calificarExamen(Examen examen) {
        Examen examenById = findById(examen.getId());
        List<Pregunta> preguntas = preguntaUseCase.findByExamenId(examen.getId());
        Map<UUID, Pregunta> preguntasOriginales = preguntas.stream()
                .collect(Collectors.toMap(Pregunta::getId, pregunta -> pregunta));

        return preguntaUseCase.calificarPreguntas(preguntasOriginales, examen.getPreguntas());
    }

    @Override
    public void activarExamen(Examen examen) {
        Examen byId = findById(examen.getId());
        byId.setFechapresentacion(examen.getFechapresentacion());
        examenRepository.save(byId);
    }

    @Override
    public List<Estudiante> registrarEstudiantesExamen(Examen examen, List<Estudiante> estudiantes) {
        estudiantes.forEach(estudiante -> {
            ExamenEstudiante examenEstudiante = ExamenEstudiante.builder().examenId(examen.getId())
                    .estudianteId(estudiante.getId()).build();
            ExamenEstudiante save = examenEstudianteRepository.save(examenEstudiante);
        });
        return calcularFechasDePresentaciónParaEstudiante(examen, estudiantes);
    }

    private List<Estudiante> calcularFechasDePresentaciónParaEstudiante(Examen examen, List<Estudiante> estudiantes){
        List<Estudiante> estudiantesList = new ArrayList<>();
        estudiantes.forEach(estudiante -> {
            Estudiante byId = estudianteUseCase.findById(estudiante.getId());
            LocalDateTime localDateTime = convertFechaExamen(examen.getFechapresentacion(), byId.getZonaHoraria());
            estudiantesList.add(Estudiante.builder().id(estudiante.getId()).nombre(estudiante.getNombre())
                    .fechapresentacion(localDateTime).build());
        });

        return estudiantesList;
    }

    private Examen findById(UUID uuid){
        Examen examen = examenRepository.findById(uuid);
        if(examen == null){
            throw new ExamenException(EXAMEN_NO_EXISTE);
        }

        return examen;
    }

    private LocalDateTime convertFechaExamen(LocalDateTime localDateTime, String zonaHorariaStr){
        ZoneId zonaHorariaBogota = ZoneId.of(ZONA_HORARIA_BOGOTA);
        ZonedDateTime zonedDateTimeBogota = ZonedDateTime.of(localDateTime, zonaHorariaBogota);
        ZoneId otraZonaHoraria = ZoneId.of(zonaHorariaStr);
        ZonedDateTime zonedDateTimeOtraZona = zonedDateTimeBogota.withZoneSameInstant(otraZonaHoraria);
        return zonedDateTimeOtraZona.toLocalDateTime();
    }

    private void validarSumaTotalDePuntos(List<Pregunta> preguntas){
        if (!esValidaLaSumaTotalDePuntos(preguntas)) {
            throw new ExamenException(CANTIDAD_DE_PUNTOS_NO_VALIDAD);
        }
    }

    private boolean esValidaLaSumaTotalDePuntos(List<Pregunta> preguntas){
        Integer totalPuntos = preguntas.stream().map(pregunta -> pregunta.getPuntos()).reduce(0, Integer::sum);
        return totalPuntos.equals(PUNTOS_TOTAL);
    }
}
