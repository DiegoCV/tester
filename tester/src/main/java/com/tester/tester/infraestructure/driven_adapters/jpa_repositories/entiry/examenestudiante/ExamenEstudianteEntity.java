package com.tester.tester.infraestructure.driven_adapters.jpa_repositories.entiry.examenestudiante;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "examen_estudiante")
public class ExamenEstudianteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "examen_id")
    private UUID examenId;
    @Column(name = "estudiante_id")
    private UUID estudianteId;
}
