package com.tpi5.mvctp5.Controller;

import com.tpi5.mvctp5.model.Carrera;
import com.tpi5.mvctp5.model.DatosAcademicos;
import com.tpi5.mvctp5.service.imp.DatosAcademicosServiceImp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("DatosAcademicos")
@Api(value = "DatosAcademicosControllerJPA", description = "REST API Datos Academicos")
public class DatosAcademicosControllerJPA {

    @Autowired
    private DatosAcademicosServiceImp datosAcademicosServ;

    @ApiOperation(value = "Get list of Datos academicos", response = Iterable.class)
    @GetMapping("/")
    public Iterable<DatosAcademicos> getDatosAcademicos() {
        return datosAcademicosServ.getAll();
    }

    @ApiOperation(value = "Matricula un estudiante en una determinada carrera", response = Iterable.class)
    @PostMapping("/matricularEstudiante/{nroLibreta}")
    public DatosAcademicos matricularse(@RequestBody Carrera c, @PathVariable(value="nroLibreta")Long nroLibreta){
        return datosAcademicosServ.matricularEstudiante(c,nroLibreta);
    }

    @ApiOperation(value = "Gradua un estudiante de una determinada carrera", response = Iterable.class)
    @PutMapping("/graduarEstudiante/{nroLibreta}")
    public DatosAcademicos graduarEstudiante(@RequestBody Carrera c, @PathVariable(value="nroLibreta")Long nroLibreta){
        return datosAcademicosServ.graduarEstudiante(c,nroLibreta);
    }

    @ApiOperation(value = "Retorna un informe de los estudiantes de cada materia ordenados por materia y año cronologicamente", response = Iterable.class)
    @GetMapping("/getInforme/")
    public Iterable<DatosAcademicos> getInforme() {
        return datosAcademicosServ.getInforme();
    }


}
