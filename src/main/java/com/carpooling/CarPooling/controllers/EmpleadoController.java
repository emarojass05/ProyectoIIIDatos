package com.carpooling.CarPooling.controllers;

import com.carpooling.CarPooling.models.EmpleadoModel;
import com.carpooling.CarPooling.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;

    @GetMapping
    public ArrayList<EmpleadoModel> obtenerEmpleados(){
        return empleadoService.obtenerEmpleados();
    }

    @PostMapping
    public EmpleadoModel guardarEmpleados(@RequestBody EmpleadoModel empleado){
        return this.empleadoService.guardarEmpleado(empleado);

    }
}
