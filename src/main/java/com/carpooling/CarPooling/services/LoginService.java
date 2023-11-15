package com.carpooling.CarPooling.services;


import org.springframework.stereotype.Service;
import com.carpooling.CarPooling.repositories.LoginRepository;

@Service
public class LoginService {
    public boolean ingresar(String nombre, String contraseña) {
        return LoginRepository.ingresar(nombre, contraseña);
    }
}
