package com.Carpooling.repositories;


import com.Carpooling.XML;
import com.Carpooling.models.EmpleadoModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class EmpleadoRepository {
    ArrayList<EmpleadoModel> Lista = new ArrayList<EmpleadoModel>();

    public static ArrayList<EmpleadoModel> obtenerEmpleado() {
        EmpleadoModel usuarioModel = new EmpleadoModel();
        ArrayList<EmpleadoModel> Lista_de_usuarios = new ArrayList<EmpleadoModel>();
        Lista_de_usuarios.add(usuarioModel);
        XML.leerXML("empleado");
        return Lista_de_usuarios;
    }

    public static EmpleadoModel guardarUsuario(EmpleadoModel empleado){
        String nomArchivo = "usuarios";
        try {
            XML.crearXMLempleado(nomArchivo, empleado);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return empleado;
    }
}
