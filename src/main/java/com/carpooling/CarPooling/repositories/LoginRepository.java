package com.carpooling.CarPooling.repositories;

import com.carpooling.CarPooling.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginRepository {
    public static boolean ingresar(String nombre, String contraseña){
        return XML.ingresar(nombre, contraseña);
    }
}
