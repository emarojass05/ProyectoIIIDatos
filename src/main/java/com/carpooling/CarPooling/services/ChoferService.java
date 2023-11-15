package com.carpooling.CarPooling.services;

import com.carpooling.CarPooling.models.ChoferModel;
import com.carpooling.CarPooling.repositories.ChoferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class ChoferService {
    @Autowired
    ChoferRepository choferRepository;

    public ArrayList<ChoferModel> obtenerChoferes() {
        return ChoferRepository.obtenerChoferes();
    }

    public ChoferModel guardarChofer(ChoferModel chofer) {
        return ChoferRepository.guardarChofer(chofer);
    }
}
