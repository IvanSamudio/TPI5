package com.tpi5.mvctp5.service.imp;

import com.tpi5.mvctp5.model.Estudiante;
import com.tpi5.mvctp5.repository.EstudianteRepository;
import com.tpi5.mvctp5.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudianteServiceImp implements EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;


    @Override
    public Estudiante getEstudianteByNroLibreta(Long nro) {
        Estudiante est = estudianteRepository.getEstudianteByNroLibreta(nro);
        return est;
    }


    @Override
    public Iterable<Estudiante> getAll() {
        return estudianteRepository.findAll();
    }

    @Override
    public Iterable<Estudiante> getAllOrderByEdad() {
        return estudianteRepository.getAllEstudiantesOrderByEdad();
    }

    @Override
    public Estudiante insertEstudiante(Estudiante e) {
        return estudianteRepository.save(e);
    }

    @Override
    public Iterable<Estudiante> getEstudiantesByCarrera(Long idCarrera, String residencia) {
        return estudianteRepository.getEstudiantesByCarreras(idCarrera,residencia);
    }

    @Override
    public Iterable<Estudiante> getEstudiantesByGenero(String genero) {
        return estudianteRepository.getAllByGenero(genero);
    }


}
