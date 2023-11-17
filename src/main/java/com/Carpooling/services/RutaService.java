package com.Carpooling.services;

import com.Carpooling.repositories.RutaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class RutaService {
    public static int calcular(@RequestBody int[] lista){
        return RutaRepository.calcular(lista);
    }
}
