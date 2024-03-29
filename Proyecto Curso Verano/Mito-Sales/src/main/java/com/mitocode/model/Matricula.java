package com.mitocode.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity

public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Es autoincremental
    @EqualsAndHashCode.Include
    private Integer idMatricula;

    @ManyToOne
    @JoinColumn(name = "id_Estudiante", nullable = false, foreignKey = @ForeignKey(name = "FK_ESTUDIANTE_MATRICULA"))
    private Estudiante estudiante;

    @Column(nullable = false)
    private LocalDateTime fechaMatricula;

    @Column(nullable = false)
    private boolean estado;

    @OneToMany(mappedBy = "matricula",cascade = CascadeType.ALL)
    private List<DetalleMatricula> detalles;


}
