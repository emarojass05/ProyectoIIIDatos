package com.carpooling.CarPooling.services;

import com.carpooling.CarPooling.models.EmpleadoModel;
import com.carpooling.CarPooling.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmpleadoService {
    @Autowired
    EmpleadoRepository usuarioRepository;

    public ArrayList<EmpleadoModel> obtenerEmpleados() {
        return EmpleadoRepository.obtenerEmpleado();
    }

    public EmpleadoModel guardarEmpleado(EmpleadoModel empleado) {
        return EmpleadoRepository.guardarUsuario(empleado);
    }
}
