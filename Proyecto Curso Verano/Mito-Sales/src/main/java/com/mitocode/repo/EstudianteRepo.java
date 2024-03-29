package com.mitocode.repo;

import com.mitocode.model.Estudiante;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

//@Service
//@Controller
//@Component
@Repository
public class EstudianteRepo {

    public Estudiante getEstudianteX(Estudiante estudiante){
        return estudiante;
    }
}
