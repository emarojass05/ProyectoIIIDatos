package com.example.login.models;

import java.util.ArrayList;

public class EmpleadoModel {

    private String name;
    private Double calificacion;
    private int ID;
    private ArrayList<ChoferModel> amigos;

    private String contraseña;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public ArrayList<ChoferModel> getAmigos() {
        return amigos;
    }

    public void setAmigos(ArrayList<ChoferModel> amigos) {
        this.amigos = amigos;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
