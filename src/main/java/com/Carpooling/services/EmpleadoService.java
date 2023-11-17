package com.Carpooling.services;


import com.Carpooling.models.EmpleadoModel;
import com.Carpooling.repositories.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmpleadoService {

    public ArrayList<EmpleadoModel> obtenerEmpleados() {
        return EmpleadoRepository.obtenerEmpleado();
    }

    public EmpleadoModel guardarEmpleado(EmpleadoModel empleado) {
        return EmpleadoRepository.guardarUsuario(empleado);
    }
}
