package com.tpi5.mvctp5.service.imp;

import com.tpi5.mvctp5.model.Carrera;
import com.tpi5.mvctp5.repository.CarreraRepository;
import com.tpi5.mvctp5.service.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarreraServiceImp implements CarreraService {
    @Autowired
    private CarreraRepository carreraRepository;

    @Override
    public Iterable<Carrera> getAll() {
        return carreraRepository.findAll();
    }

    @Override
    public Carrera insertCarrera(Carrera c) {
        return carreraRepository.save(c);
    }

    @Override
    public Carrera getCarreraByIdCarrera(Long idCarrera) {
        return carreraRepository.getCarreraByIdCarrera(idCarrera);
    }

    @Override
    public Iterable<Carrera> getCarreraByInscriptos() {
        return carreraRepository.getCarreraByInscriptos();
    }
}
