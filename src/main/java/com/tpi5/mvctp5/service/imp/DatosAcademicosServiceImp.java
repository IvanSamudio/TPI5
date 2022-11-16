package com.tpi5.mvctp5.service.imp;

import com.tpi5.mvctp5.model.Carrera;
import com.tpi5.mvctp5.model.DatosAcademicos;
import com.tpi5.mvctp5.model.Estudiante;
import com.tpi5.mvctp5.repository.DatosAcademicosRepository;
import com.tpi5.mvctp5.service.DatosAcademicosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatosAcademicosServiceImp implements DatosAcademicosService {

    @Autowired
    private DatosAcademicosRepository DatosAcademicosRepository;

    @Override
    public Iterable<DatosAcademicos> getAll() {
        return DatosAcademicosRepository.findAll();
    }

    @Override
    public DatosAcademicos matricularEstudiante(Carrera c, Long nroLibreta) {
        Estudiante estudiante = DatosAcademicosRepository.getEstudianteByNroLibreta(nroLibreta);
        DatosAcademicos dat = new DatosAcademicos(c,estudiante);
        return DatosAcademicosRepository.save(dat);
    }

    @Override
    public DatosAcademicos graduarEstudiante(Carrera c, Long nroLibreta) {
        DatosAcademicos dat = DatosAcademicosRepository.getDatosAcademicos(nroLibreta,c.getIdCarrera());
        dat.graduarEstudiante();
        return DatosAcademicosRepository.save(dat);
    }

    @Override
    public Iterable<DatosAcademicos> getInforme() {
        return DatosAcademicosRepository.getInformeDatosAcademicos();
    }


}
