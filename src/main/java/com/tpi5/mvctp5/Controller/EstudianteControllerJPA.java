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
@Api(value = "EstudianteControllerJPA", description = "REST API estudiante")
public class EstudianteControllerJPA {

    @Autowired
    private EstudianteServiceImp estudianteService;

    @ApiOperation(value = "Get list of estudiantes", response = Iterable.class)
    @GetMapping("/")
    public Iterable<Estudiante> getEstudiantes() {
        return estudianteService.getAll();
    }

    @ApiOperation(value = "Get list of estudiantes order by edad", response = Iterable.class)
    @GetMapping("/orderByEdad/")
    public Iterable<Estudiante> getEstudiantesByEdad() {
        return estudianteService.getAllOrderByEdad();
    }

    @ApiOperation(value = "Get estudiante by numero de libreta universitaria", response = Iterable.class)
    @GetMapping("/getEstudiante/{nroLibreta}")
    public Estudiante getEstudiante(@PathVariable(value = "nroLibreta") Long nroLibreta) {
        return estudianteService.getEstudianteByNroLibreta(nroLibreta);
    }

    @ApiOperation(value = "Get estudiante by genero", response = Iterable.class)
    @GetMapping("/{genero}")
    public Iterable<Estudiante> getEstudiante(@PathVariable(value = "genero") String genero) {
        return estudianteService.getEstudiantesByGenero(genero.toLowerCase(Locale.ROOT));
    }

    @ApiOperation(value = "Post estudiante", response = Iterable.class)
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
