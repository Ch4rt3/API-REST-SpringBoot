package com.mitocode.service;

import com.mitocode.model.Matricula;

import java.util.List;
import java.util.Map;

public interface IMatriculaService extends ICRUD<Matricula,Integer>{


    public Map<String, List<String>> obtenerRelacionCursosEstudiantes();
}
