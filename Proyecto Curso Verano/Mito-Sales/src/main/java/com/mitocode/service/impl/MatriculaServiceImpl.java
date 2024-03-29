package com.mitocode.service.impl;

import com.mitocode.model.DetalleMatricula;
import com.mitocode.model.Matricula;
import com.mitocode.repo.iGenericRepo;
import com.mitocode.repo.iMatriculaRepo;
import com.mitocode.service.IMatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

@Service
@RequiredArgsConstructor
public class MatriculaServiceImpl extends CRUDImpl<Matricula,Integer> implements IMatriculaService {

    //@Autowired
    private final iMatriculaRepo repo;

    @Override
    protected iGenericRepo<Matricula, Integer> getRepo() {
        return repo;
    }

    @Override
    public Map<String, List<String>> obtenerRelacionCursosEstudiantes() {
        return repo.findAll().stream()
                .flatMap(matricula -> matricula.getDetalles().stream())
                .collect(Collectors.groupingBy(
                        detalleMatricula -> detalleMatricula.getCurso().getNombre(),
                        Collectors.mapping(
                                detalleMatricula -> detalleMatricula.getMatricula().getEstudiante().getNombres() + " " +
                                        detalleMatricula.getMatricula().getEstudiante().getApellidos(),
                                Collectors.toList()
                        )
                ));
    }
}
