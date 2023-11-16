package com.carpooling.CarPooling.services;

import com.carpooling.CarPooling.Graph;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.carpooling.CarPooling.repositories.RutaRepository;

@Service
public class RutaService {
    public static int calcular(@RequestBody int[] lista){
        return RutaRepository.calcular(lista);
    }
}
