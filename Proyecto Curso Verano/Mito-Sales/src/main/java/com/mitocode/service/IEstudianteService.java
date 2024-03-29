package com.mitocode.service;

import com.mitocode.model.Estudiante;

import java.util.List;
import java.util.Map;

public interface IEstudianteService extends ICRUD<Estudiante,Integer> {

    List<Estudiante> findByNombresService(String nombres);

    List<Estudiante> findAllOrder(String param );

}
