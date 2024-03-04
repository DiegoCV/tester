package com.tester.tester.infraestructure.entry_points.examen;

import com.tester.tester.domain.model.Estudiante;
import com.tester.tester.domain.model.Examen;
import com.tester.tester.domain.model.Pregunta;
import com.tester.tester.domain.usecase.ExamenUseCase;
import com.tester.tester.infraestructure.entry_points.examen.model.EstudianteRequest;
import com.tester.tester.infraestructure.entry_points.examen.model.ActivarExamenRequest;
import com.tester.tester.infraestructure.entry_points.examen.model.ExamenRequest;
import com.tester.tester.infraestructure.entry_points.examen.model.PreguntaRequest;
import com.tester.tester.infraestructure.entry_points.util.FechaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/examen")
public class ExamenController {

    @Autowired
    ExamenUseCase examenUseCase;

    @PostMapping
    public ResponseEntity<Examen> crearExamen(@RequestBody ExamenRequest examenRequest){
        Examen examen = examenUseCase.crearExamen(toExamen(examenRequest));
        return ResponseEntity.ok(examen);
    }

    @PostMapping(value = "/{id}/activar")
    public ResponseEntity<List<Estudiante>> activarExamen(@PathVariable("id") UUID id,
                                          @RequestBody ActivarExamenRequest activarExamenRequest){
        LocalDateTime localDateTime = FechaUtil.toLocalDateTime(activarExamenRequest.getFecha());
        Examen examen = Examen.builder().id(id).fechapresentacion(localDateTime).build();
        examenUseCase.activarExamen(examen);
        List<Estudiante> estudianteList = examenUseCase.registrarEstudiantesExamen(examen, activarExamenRequest
                .getEstudiantes().stream().map(this::toEstudiante).collect(Collectors.toList()));

        return ResponseEntity.ok(estudianteList);
    }

    private Examen toExamen(ExamenRequest examenRequest){
        return Examen.builder().titulo(examenRequest.getTitulo()).preguntas(examenRequest.getPreguntas().stream()
                .map(this::toPregunta).collect(Collectors.toList())).build();
    }

    private Pregunta toPregunta(PreguntaRequest preguntaRequest){
            return Pregunta.builder()
                    .enunciado(preguntaRequest.getEnunciado())
                    .opcionA(preguntaRequest.getOpcionA())
                    .opcionB(preguntaRequest.getOpcionB())
                    .opcionC(preguntaRequest.getOpcionC())
                    .opcionD(preguntaRequest.getOpcionD())
                    .opcionCorrecta(preguntaRequest.getOpcionCorrecta())
                    .puntos(preguntaRequest.getPuntos()).build();
    }

    private Estudiante toEstudiante(EstudianteRequest estudianteRequest){
        return Estudiante.builder().id(UUID.fromString(estudianteRequest.getId())).build();
    }
}
