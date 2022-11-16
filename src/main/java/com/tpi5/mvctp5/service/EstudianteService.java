package com.tpi5.mvctp5.service;

import com.tpi5.mvctp5.model.Estudiante;
import org.springframework.stereotype.Component;

@Component
public interface EstudianteService {

    public Estudiante getEstudianteByNroLibreta(Long nro);

    public Iterable<Estudiante> getAll();

    public Iterable<Estudiante> getAllOrderByEdad();

    public Estudiante insertEstudiante(Estudiante e);

    public Iterable<Estudiante> getEstudiantesByCarrera(Long idCarrera,String residencia);

    public Iterable<Estudiante> getEstudiantesByGenero(String genero);
}
