package com.tpi5.mvctp5.service;

import com.tpi5.mvctp5.model.Carrera;
import org.springframework.stereotype.Component;

@Component
public interface CarreraService {

    public Iterable<Carrera> getAll();

    public Carrera insertCarrera(Carrera c);

    public Carrera getCarreraByIdCarrera(Long idCarrera);

    public Iterable<Carrera> getCarreraByInscriptos();
}
