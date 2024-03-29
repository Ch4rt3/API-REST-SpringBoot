package com.mitocode.repo;

import com.mitocode.model.Estudiante;

import java.util.List;

public interface iEstudianteRepo extends iGenericRepo<Estudiante,Integer> {

    //DerivedQueries
    //SELECT * FROM Estudiante c WHERE c.name = ''

    List<Estudiante> findByNombres(String nombres);

    List<Estudiante> findByNombresLike(String nombres);
}
