package com.tpi5.mvctp5.service;

import com.tpi5.mvctp5.model.Carrera;
import com.tpi5.mvctp5.model.DatosAcademicos;
import org.springframework.stereotype.Component;

@Component
public interface DatosAcademicosService {

    public Iterable<DatosAcademicos> getAll();

    public DatosAcademicos matricularEstudiante(Carrera c, Long nroLibreta);

    public DatosAcademicos graduarEstudiante(Carrera c,Long nroLibreta);

    public Iterable<DatosAcademicos> getInforme();
}
