package com.mitocode.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EstudianteDTO {

    private Integer idEstudiante;

    @NotNull
    //@NotEmpty
    //@NotBlank
    @Size(min = 3,max=40)
    //@Pattern(regexp = "[0-9]+")
    //@Email
    private String nombresEstudiante;

    private String apellidos;

    private String dni;

    private int edad;
}
