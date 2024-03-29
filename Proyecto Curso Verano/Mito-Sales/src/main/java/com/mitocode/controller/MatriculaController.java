package com.mitocode.controller;

import com.mitocode.dto.MatriculaDTO;
import com.mitocode.dto.GenericResponse;
import com.mitocode.model.Matricula;
import com.mitocode.service.IMatriculaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/matriculas")
@RequiredArgsConstructor
public class MatriculaController {

    //@Autowired
    private final IMatriculaService service;
    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<MatriculaDTO>> readAll() throws Exception{

        //ModelMapper modelMapper = new ModelMapper();

        List<MatriculaDTO> list = service.readAll().stream().map(this::convertToDTO).toList();

        //return ResponseEntity.ok(list);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<MatriculaDTO>> readById(@PathVariable("id")Integer id) throws Exception{
        //return service.readById(id);
        Matricula obj = service.readById(id);

        return ResponseEntity.ok(new GenericResponse<>(200,"success", Arrays.asList(convertToDTO(obj))));
    }

    @PostMapping
    public ResponseEntity<MatriculaDTO> save(@Valid @RequestBody MatriculaDTO dto) throws Exception{
        //return service.save(matricula);
        Matricula obj = service.save(convertToEntity(dto));

        return new ResponseEntity<>(convertToDTO(obj),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatriculaDTO> update(@Valid @RequestBody MatriculaDTO dto, @PathVariable("id") Integer id) throws Exception{
        //return service.update(matricula,id);
        Matricula obj = service.update(convertToEntity(dto),id);

        return  ResponseEntity.ok(convertToDTO(obj));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);

        //return ResponseEntity.noContent().build();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/estudiantesYmatriculas")
    public ResponseEntity<Map<String,List<String>>> obtenerRelacionCursosEstudiantes(){
        Map<String,List<String>> est = service.obtenerRelacionCursosEstudiantes();
        return new ResponseEntity<>(est,HttpStatus.OK);
    }

    private MatriculaDTO convertToDTO(Matricula obj){
        return modelMapper.map(obj,MatriculaDTO.class);
    }

    private Matricula convertToEntity(MatriculaDTO obj){
        return modelMapper.map(obj,Matricula.class);
    }
    /*
    @GetMapping
    public Matricula getMatriculaEjemplo(){
        //service = new MatriculaService();

        return service.validateMatricula(new Matricula(1,"Fantino","Camara Mora","74763044",20));
    }*/
}
