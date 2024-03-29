package com.mitocode.dto;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.mitocode.model.Matricula;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DetalleMatriculaDTO {

    //private Integer idDetalleMatricula;

    //@NotNull
    @Min(value = 1)
    @JsonBackReference
    private MatriculaDTO matricula;

    @NotNull
    @Min(value = 1)
    private CursoDTO curso;

    @NotNull
    private String aula;
}
