package com.mitocode.service.impl;

import com.mitocode.model.Curso;
import com.mitocode.model.Estudiante;
import com.mitocode.model.Matricula;
import com.mitocode.repo.iCursoRepo;
import com.mitocode.repo.iEstudianteRepo;
import com.mitocode.repo.iGenericRepo;
import com.mitocode.service.ICursoService;
import com.mitocode.service.IEstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl extends CRUDImpl<Curso,Integer> implements ICursoService {

    //@Autowired
    private final iCursoRepo repo;


    @Override
    protected iGenericRepo<Curso, Integer> getRepo() {
        return repo;
    }

}
