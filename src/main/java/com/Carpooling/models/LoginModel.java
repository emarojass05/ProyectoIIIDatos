package com.Carpooling.models;
/**
 *La clase LoginModel representa el modelo que tendra el login
 */
public class LoginModel {
    String ID;
    String contraseña;

    /**
     * Obtiene el ID
     */
    public String getName() {
        return ID;
    }

    /**
     * Actualiza el ID
     */

    public void setNombre(String nombre) {
        this.ID = nombre;
    }

    /**
     * Obtiene la contraseña
     */

    public String getContraseña() {
        return contraseña;
    }

    /**
     * Actualiza la contraseña
     */

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
