package com.Carpooling.controllers;


import com.Carpooling.models.ChoferModel;
import com.Carpooling.models.EmpleadoModel;
import com.Carpooling.services.ChoferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/chofer")
public class ChoferController {
    @Autowired
    ChoferService choferService;

    @GetMapping
    public ArrayList<ChoferModel> obtenerChoferes(){
        return choferService.obtenerChoferes();
    }

    @PostMapping
    public ChoferModel guardarChoferes(@RequestBody ChoferModel chofer){
        return this.choferService.guardarChofer(chofer);

    }

}
