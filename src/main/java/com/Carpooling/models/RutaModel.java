package com.Carpooling.models;
/**
 *La clase RutaModel representa el modelo que tendran las peticiones para la ruta
 */
public class RutaModel {
    /**
     * Representa la ruta
     */
    int[] ruta;

    /**
     * Obtiene la ruta
     */
    public int[] getRuta() {
        return ruta;
    }

    /**
     * Actualiza la ruta
     */
    public void setRuta(int[] ruta) {
        this.ruta = ruta;
    }

}
