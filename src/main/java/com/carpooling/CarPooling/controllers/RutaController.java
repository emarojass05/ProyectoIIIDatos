package com.carpooling.CarPooling.controllers;
import com.carpooling.CarPooling.Graph;
import com.carpooling.CarPooling.models.RutaModel;
import com.carpooling.CarPooling.services.RutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ruta")
public class RutaController {
    @Autowired
    RutaService rutaService;

    @GetMapping
    public int calcular(@RequestBody RutaModel ruta){
        return RutaService.calcular(ruta.getRuta());
    }
}
