package com.Carpooling.controllers;


import com.Carpooling.models.LoginModel;
import com.Carpooling.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping
    public boolean ingresar(@RequestBody LoginModel login){
        return this.loginService.ingresar(login.getName(), login.getContraseña());
    }

}
