package com.mitocode.service.impl;

import com.mitocode.model.Estudiante;
import com.mitocode.repo.iEstudianteRepo;
import com.mitocode.repo.iGenericRepo;
import com.mitocode.service.IEstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstudianteServiceImpl extends CRUDImpl<Estudiante,Integer> implements IEstudianteService {

    //@Autowired
    private final iEstudianteRepo repo;


    @Override
    protected iGenericRepo<Estudiante, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<Estudiante> findByNombresService(String nombres) {
        return repo.findByNombresLike("%"+nombres+"%");
    }

    @Override
    public List<Estudiante> findAllOrder(String param) {
        Sort.Direction direction = param.equalsIgnoreCase("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC;
        return repo.findAll(Sort.by(direction,"edad"));
    }


}
