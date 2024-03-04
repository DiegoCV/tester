package com.tester.tester.infraestructure.entry_points.estudiante;

import com.tester.tester.domain.model.Estudiante;
import com.tester.tester.domain.usecase.EstudianteUseCase;
import com.tester.tester.infraestructure.entry_points.estudiante.model.EstudianteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/estudiante")
public class EstudianteController {

    @Autowired
    EstudianteUseCase estudianteUseCase;

    @PostMapping
    public ResponseEntity<Estudiante> crearEstudiante(@RequestBody EstudianteRequest estudianteRequest){
        Estudiante save = estudianteUseCase.save(toEstudiante(estudianteRequest));
        return ResponseEntity.ok(save);
    }

    private Estudiante toEstudiante(EstudianteRequest estudianteRequest){
        return Estudiante.builder().nombre(estudianteRequest.getNombre()).edad(estudianteRequest.getEdad())
                .ciudad(estudianteRequest.getCiudad()).zonaHoraria(estudianteRequest.getZonaHoraria()).build();
    }
}
