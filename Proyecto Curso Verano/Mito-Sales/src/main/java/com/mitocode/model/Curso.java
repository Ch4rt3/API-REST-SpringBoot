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

public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Es autoincremental
    @EqualsAndHashCode.Include
    private Integer idCurso;

    @Column(nullable = false, length = 80)
    private String nombre;

    @Column(nullable = false, length = 40)
    private String siglas;

    private boolean estado;
}
