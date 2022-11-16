package com.tpi5.mvctp5.Controller;

import com.tpi5.mvctp5.model.Carrera;
import com.tpi5.mvctp5.service.imp.CarreraServiceImp;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Carreras")
@Api(value = "CarreraControllerJPA", description = "REST API carrera description")
public class CarreraControllerJPA {

    @Autowired
    private CarreraServiceImp carreraService;


    @GetMapping("/")
    public Iterable<Carrera> getCarreras() {
        return carreraService.getAll();
    }

    @PostMapping()
    public Carrera newCarrera(@RequestBody Carrera c) {
        return carreraService.insertCarrera(c);
    }

    @RequestMapping(value = "/getCarrera/{idCarrera}")
    public Carrera getCarrera(@PathVariable(value = "idCarrera") Long idCarrera) {
        return carreraService.getCarreraByIdCarrera(idCarrera);
    }

    @GetMapping("/getCarrerasConInscriptos/")
    public Iterable<Carrera> getCarrerasConInscriptos() {
        return carreraService.getCarreraByInscriptos();
    }

}
