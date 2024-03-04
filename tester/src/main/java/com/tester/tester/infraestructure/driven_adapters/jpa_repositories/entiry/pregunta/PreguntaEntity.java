package com.tester.tester.infraestructure.driven_adapters.jpa_repositories.entiry.pregunta;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pregunta")
public class PreguntaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String enunciado;
    private String opcionA;
    private String opcionB;
    private String opcionC;
    private String opcionD;
    @Column(name = "opcioncorrecta")
    private String opcionCorrecta;
    private int puntos;
    @Column(name = "examen_id", nullable = false)
    private UUID examenId;
}
