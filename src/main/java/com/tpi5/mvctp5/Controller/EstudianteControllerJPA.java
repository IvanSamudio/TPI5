package com.tpi5.mvctp5.Controller;


import com.tpi5.mvctp5.model.Estudiante;
import com.tpi5.mvctp5.service.imp.EstudianteServiceImp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;


@RestController
@RequestMapping("Estudiantes")
@Api(value = "EstudianteControllerJPA", description = "REST API estudiante description")
public class EstudianteControllerJPA {

    @Autowired
    private EstudianteServiceImp estudianteService;


    @GetMapping("/")
    public Iterable<Estudiante> getEstudiantes() {
        return estudianteService.getAll();
    }

    @GetMapping("/orderByEdad/")
    public Iterable<Estudiante> getEstudiantesByEdad() {
        return estudianteService.getAllOrderByEdad();
    }


    @GetMapping("/getEstudiante/{nroLibreta}")
    public Estudiante getEstudiante(@PathVariable(value = "nroLibreta") Long nroLibreta) {
        return estudianteService.getEstudianteByNroLibreta(nroLibreta);
    }

    @GetMapping("/{genero}")
    public Iterable<Estudiante> getEstudiante(@PathVariable(value = "genero") String genero) {
        return estudianteService.getEstudiantesByGenero(genero.toLowerCase(Locale.ROOT));
    }

    @PostMapping()
    public Estudiante newEstudiante(@RequestBody Estudiante e) {
        return estudianteService.insertEstudiante(e);
    }


    @ApiOperation(value = "Get list of estudiantes by carrera ", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping("/getEstudiantesByCarrera/{idCarrera}/{residencia}")
    public Iterable<Estudiante> getEstudiante(@PathVariable(value = "idCarrera") Long idCarrera,@PathVariable(value = "residencia") String residencia) {
        return estudianteService.getEstudiantesByCarrera(idCarrera,residencia.toLowerCase(Locale.ROOT));
    }


}
