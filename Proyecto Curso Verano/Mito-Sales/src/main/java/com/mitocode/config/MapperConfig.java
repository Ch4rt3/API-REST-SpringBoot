package com.mitocode.config;


import com.mitocode.dto.CursoDTO;
import com.mitocode.dto.EstudianteDTO;
import com.mitocode.dto.MatriculaDTO;
import com.mitocode.model.Curso;
import com.mitocode.model.Estudiante;
import com.mitocode.model.Matricula;
import jdk.jfr.Category;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;

@Configuration
public class MapperConfig {

    @Bean("estudianteMapper")
    public ModelMapper estudianteMapper(){
        ModelMapper mapper = new ModelMapper();
        //Lectura
        TypeMap<Estudiante, EstudianteDTO> typeMap1= mapper.createTypeMap(Estudiante.class,EstudianteDTO.class);
        typeMap1.addMapping(Estudiante::getNombres,(dest, val)->dest.setNombresEstudiante((String) val));

        //Escritura
        TypeMap<EstudianteDTO, Estudiante> typeMap2= mapper.createTypeMap(EstudianteDTO.class,Estudiante.class);
        typeMap2.addMapping(EstudianteDTO::getNombresEstudiante,(dest, val)->dest.setNombres((String) val));

        return mapper;
    }

    @Bean("cursoMapper")
    public ModelMapper cursoMapper(){
        ModelMapper mapper = new ModelMapper();

        //Lectura
        TypeMap<Curso, CursoDTO> typeMap1 = mapper.createTypeMap(Curso.class,CursoDTO.class);
        typeMap1.addMapping(Curso::getNombre,(dest,val)->dest.setNombreCurso((String) val));
        //Escritura
        TypeMap<CursoDTO, Curso> typeMap2 = mapper.createTypeMap(CursoDTO.class,Curso.class);
        typeMap2.addMapping(CursoDTO::getNombreCurso,(dest,val)->dest.setNombre((String) val));

        return mapper;
    }

    @Bean("matriculaMapper")
    public ModelMapper matriculaMapper(){
        ModelMapper mapper = new ModelMapper();

        //Lectura
        /*TypeMap<MatriculaDTO, Matricula> typeMap1 = mapper.createTypeMap(MatriculaDTO.class,Matricula.class);
        typeMap1.addMapping(MatriculaDTO::getEstudiante,(dest,val)->dest.getEstudiante().setIdEstudiante((Integer) val));
        //Escritura
        TypeMap<Matricula, MatriculaDTO> typeMap2 = mapper.createTypeMap(Matricula.class,MatriculaDTO.class);
        typeMap2.addMapping(e-> e.getEstudiante().getIdEstudiante(),(dest,val)->dest.setEstudiante((Integer) val));*/

        return mapper;
    }

    @Bean("defaultMapper")
    public ModelMapper defaultMapper(){
        return new ModelMapper();
    }
}
