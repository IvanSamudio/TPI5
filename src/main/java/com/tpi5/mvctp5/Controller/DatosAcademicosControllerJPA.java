package com.tpi5.mvctp5.Controller;

import com.tpi5.mvctp5.model.Carrera;
import com.tpi5.mvctp5.model.DatosAcademicos;
import com.tpi5.mvctp5.service.imp.DatosAcademicosServiceImp;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("DatosAcademicos")
@Api(value = "DatosAcademicosControllerJPA", description = "REST API DatosAcademicos description")
public class DatosAcademicosControllerJPA {

    @Autowired
    private DatosAcademicosServiceImp datosAcademicosServ;


    @GetMapping("/")
    public Iterable<DatosAcademicos> getDatosAcademicos() {
        return datosAcademicosServ.getAll();
    }

    @PostMapping("/matricularEstudiante/{nroLibreta}")
    public DatosAcademicos matricularse(@RequestBody Carrera c, @PathVariable(value="nroLibreta")Long nroLibreta){
        return datosAcademicosServ.matricularEstudiante(c,nroLibreta);
    }

    @PutMapping("/graduarEstudiante/{nroLibreta}")
    public DatosAcademicos graduarEstudiante(@RequestBody Carrera c, @PathVariable(value="nroLibreta")Long nroLibreta){
        return datosAcademicosServ.graduarEstudiante(c,nroLibreta);
    }

    @GetMapping("/getInforme/")
    public Iterable<DatosAcademicos> getInforme() {
        return datosAcademicosServ.getInforme();
    }


}
