package com.mitocode.controller;

import com.mitocode.dto.CursoDTO;
import com.mitocode.dto.GenericResponse;
import com.mitocode.model.Curso;
import com.mitocode.service.ICursoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor
public class CursoController {

    //@Autowired
    private final ICursoService service;
    @Qualifier("cursoMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<CursoDTO>> readAll() throws Exception{

        //ModelMapper modelMapper = new ModelMapper();

        List<CursoDTO> list = service.readAll().stream().map(this::convertToDTO).toList();

        //return ResponseEntity.ok(list);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<CursoDTO>> readById(@PathVariable("id")Integer id) throws Exception{
        //return service.readById(id);
        Curso obj = service.readById(id);

        return ResponseEntity.ok(new GenericResponse<>(200,"success", Arrays.asList(convertToDTO(obj))));
    }

    @PostMapping
    public ResponseEntity<CursoDTO> save(@Valid @RequestBody CursoDTO dto) throws Exception{
        //return service.save(curso);
        Curso obj = service.save(convertToEntity(dto));

        return new ResponseEntity<>(convertToDTO(obj),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoDTO> update(@Valid @RequestBody CursoDTO dto, @PathVariable("id") Integer id) throws Exception{
        //return service.update(curso,id);
        Curso obj = service.update(convertToEntity(dto),id);

        return  ResponseEntity.ok(convertToDTO(obj));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);

        //return ResponseEntity.noContent().build();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    private CursoDTO convertToDTO(Curso obj){
        return modelMapper.map(obj,CursoDTO.class);
    }

    private Curso convertToEntity(CursoDTO obj){
        return modelMapper.map(obj,Curso.class);
    }
    /*
    @GetMapping
    public Curso getCursoEjemplo(){
        //service = new CursoService();

        return service.validateCurso(new Curso(1,"Fantino","Camara Mora","74763044",20));
    }*/
}
