package com.Carpooling.services;


import com.Carpooling.repositories.LoginRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public boolean ingresar(String nombre, String contraseña) {
        return LoginRepository.ingresar(nombre, contraseña);
    }
}
