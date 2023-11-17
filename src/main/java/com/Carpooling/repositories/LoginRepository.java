package com.Carpooling.repositories;


import com.Carpooling.XML;
import org.springframework.stereotype.Repository;

@Repository
public class LoginRepository {
    public static boolean ingresar(String nombre, String contraseña){
        return XML.ingresar(nombre, contraseña);
    }
}
