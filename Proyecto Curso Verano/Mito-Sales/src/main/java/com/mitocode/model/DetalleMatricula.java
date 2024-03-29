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

public class DetalleMatricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Es autoincremental
    @EqualsAndHashCode.Include
    private Integer idDetalleMatricula;

    @ManyToOne
    @JoinColumn(name = "id_Matricula", nullable = false, foreignKey = @ForeignKey(name = "FK_DETALLE_MATRICULA"))
    private Matricula matricula;

    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false, foreignKey = @ForeignKey(name = "FK_DETALLE_CURSO"))
    private Curso curso;

    @Column(nullable = false)
    private String aula;


}
