package com.tester.tester.infraestructure.entry_points.pregunta;

import com.tester.tester.domain.model.Examen;
import com.tester.tester.domain.model.Pregunta;
import com.tester.tester.domain.usecase.ExamenUseCase;
import com.tester.tester.infraestructure.entry_points.pregunta.model.ExamenRequest;
import com.tester.tester.infraestructure.entry_points.pregunta.model.PreguntaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("api/pregunta")
public class PreguntaController {

    @Autowired
    ExamenUseCase examenUseCase;

    @PostMapping
    public ResponseEntity<Integer> calificarPreguntas(@RequestBody ExamenRequest examenRequest) {
       int in = examenUseCase.calificarExamen(toExamen(examenRequest));
        return ResponseEntity.ok(in);
    }

    private Examen toExamen(ExamenRequest examenRequest){
        return Examen.builder().id(examenRequest.getId()).preguntas(
                examenRequest.getPreguntas().stream().map(this::toPregunta).collect(Collectors.toList()))
                .build();
    }

    private Pregunta toPregunta(PreguntaRequest preguntaRequest){
        return Pregunta.builder().id(preguntaRequest.getId())
                .opcionSeleccionada(preguntaRequest.getOpcionSeleccionada()).build();
    }
}