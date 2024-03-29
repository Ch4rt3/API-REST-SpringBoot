package com.mitocode.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity

public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Es autoincremental
    @EqualsAndHashCode.Include
    private Integer idEstudiante;
    @Column(nullable = false, length = 50)
    private String nombres;
    @Column(nullable = false,length = 50)
    private String apellidos;
    @Column(nullable = false,length = 50)
    private String dni;
    private int edad;

}
