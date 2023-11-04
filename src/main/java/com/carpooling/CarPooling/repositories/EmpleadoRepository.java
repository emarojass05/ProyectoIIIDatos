package com.carpooling.CarPooling.repositories;

import com.carpooling.CarPooling.models.EmpleadoModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class EmpleadoRepository {

    ArrayList<EmpleadoModel> Lista = new ArrayList<EmpleadoModel>();

    public static ArrayList<EmpleadoModel> obtenerEmpleado() {
        EmpleadoModel usuarioModel = new EmpleadoModel();
        ArrayList<EmpleadoModel> Lista_de_usuarios = new ArrayList<EmpleadoModel>();
        Lista_de_usuarios.add(usuarioModel);
        return Lista_de_usuarios;
    }

    public static EmpleadoModel guardarUsuario(EmpleadoModel empleado){
        empleado.setName(empleado.getName());
        empleado.setRol(empleado.getRol());
        return empleado;
    }
}
