package com.Carpooling.services;


import com.Carpooling.models.ChoferModel;
import com.Carpooling.repositories.ChoferRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ChoferService {

    public ArrayList<ChoferModel> obtenerChoferes() {
        return ChoferRepository.obtenerChoferes();
    }

    public ChoferModel guardarChofer(ChoferModel chofer) {
        return ChoferRepository.guardarChofer(chofer);
    }
}
