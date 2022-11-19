package com.tpi5.mvctp5.Controller;

import com.tpi5.mvctp5.model.Carrera;
import com.tpi5.mvctp5.service.imp.CarreraServiceImp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Carreras")
@Api(value = "CarreraControllerJPA", description = "REST API carrera")
public class CarreraControllerJPA {

    @Autowired
    private CarreraServiceImp carreraService;

    @ApiOperation(value = "Get list of carreras", response = Iterable.class)
    @GetMapping("/")
    public Iterable<Carrera> getCarreras() {
        return carreraService.getAll();
    }

    @ApiOperation(value = "Crea una nueva carrera", response = Iterable.class)
    @PostMapping()
    public Carrera newCarrera(@RequestBody Carrera c) {
        return carreraService.insertCarrera(c);
    }

    @ApiOperation(value = "Get carrera by idCarrera", response = Iterable.class)
    @GetMapping(value = "/getCarrera/{idCarrera}")
    public Carrera getCarrera(@PathVariable(value = "idCarrera") Long idCarrera) {
        return carreraService.getCarreraByIdCarrera(idCarrera);
    }

    @ApiOperation(value = "Retorna una lista de carreras las cuales tienen estudiantes inscriptos", response = Iterable.class)
    @GetMapping("/getCarrerasConInscriptos/")
    public Iterable<Carrera> getCarrerasConInscriptos() {
        return carreraService.getCarreraByInscriptos();
    }

}
