package com.mitocode.controller;

import com.mitocode.dto.EstudianteDTO;
import com.mitocode.dto.GenericResponse;
import com.mitocode.model.Estudiante;
import com.mitocode.service.IEstudianteService;
import jakarta.validation.Valid;
import jdk.jfr.Category;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/estudiantes")
@RequiredArgsConstructor
public class EstudianteController {

    //@Autowired
    private final IEstudianteService service;
    @Qualifier("estudianteMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<EstudianteDTO>> readAll() throws Exception{

        //ModelMapper modelMapper = new ModelMapper();

        List<EstudianteDTO> list = service.readAll().stream().map(this::convertToDTO).toList();

        //return ResponseEntity.ok(list);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<EstudianteDTO>> readById(@PathVariable("id")Integer id) throws Exception{
        //return service.readById(id);
        Estudiante obj = service.readById(id);

        return ResponseEntity.ok(new GenericResponse<>(200,"success", Arrays.asList(convertToDTO(obj))));
    }

    @PostMapping
    public ResponseEntity<EstudianteDTO> save(@Valid @RequestBody EstudianteDTO dto) throws Exception{
        //return service.save(estudiante);
        Estudiante obj = service.save(convertToEntity(dto));

        return new ResponseEntity<>(convertToDTO(obj),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstudianteDTO> update(@Valid @RequestBody EstudianteDTO dto, @PathVariable("id") Integer id) throws Exception{
        //return service.update(estudiante,id);
        Estudiante obj = service.update(convertToEntity(dto),id);

        return  ResponseEntity.ok(convertToDTO(obj));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);

        //return ResponseEntity.noContent().build();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /////////////////////QUERIES////////////////////////////

    @GetMapping("find/nombres/{nombres}")
    public ResponseEntity<List<EstudianteDTO>> findByNombres(@PathVariable("nombres") String nombres){
        List<EstudianteDTO> list =  service.findByNombresService(nombres).stream().map(this::convertToDTO).toList();

        return ResponseEntity.ok(list);
    }

    //localhost:8080/estudiantes/order?param=DESC
    @GetMapping("/order")
    public ResponseEntity<List<EstudianteDTO>> findAllOrder(@RequestParam(name = "param", defaultValue = "ASC") String param){
        List<EstudianteDTO> list = service.findAllOrder(param).stream().map(this::convertToDTO).toList();

        return ResponseEntity.ok(list);
    }

    private EstudianteDTO convertToDTO(Estudiante obj){
        return modelMapper.map(obj,EstudianteDTO.class);
    }

    private Estudiante convertToEntity(EstudianteDTO obj){
        return modelMapper.map(obj,Estudiante.class);
    }
    /*
    @GetMapping
    public Estudiante getEstudianteEjemplo(){
        //service = new EstudianteService();

        return service.validateEstudiante(new Estudiante(1,"Fantino","Camara Mora","74763044",20));
    }*/
}
