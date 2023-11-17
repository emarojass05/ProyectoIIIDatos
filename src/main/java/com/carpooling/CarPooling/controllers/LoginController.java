package com.carpooling.CarPooling.controllers;

import com.carpooling.CarPooling.models.EmpleadoModel;
import com.carpooling.CarPooling.models.LoginModel;
import com.carpooling.CarPooling.services.EmpleadoService;
import com.carpooling.CarPooling.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping
    public boolean ingresar(@RequestBody LoginModel login){
        return this.loginService.ingresar(login.getName(), login.getContraseña());
    }

    @PostMapping
    public boolean ingresarr(@RequestBody LoginModel login){
        return this.loginService.ingresar(login.getName(), login.getContraseña());
    }
}
