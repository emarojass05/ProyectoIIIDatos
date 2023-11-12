package com.carpooling.CarPooling.repositories;

import com.carpooling.CarPooling.models.ChoferModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public class ChoferRepository {
    ArrayList<ChoferModel> Lista = new ArrayList<ChoferModel>();

    public static ArrayList<ChoferModel> obtenerChoferes() {
        ChoferModel choferModel = new ChoferModel();
        ArrayList<ChoferModel> Lista_de_choferes = new ArrayList<ChoferModel>();
        Lista_de_choferes.add(choferModel);
        return Lista_de_choferes;

//
//    public static ChoferModel guardarChofer(ChoferModel chofer){
//        return chofer;
    }
}
