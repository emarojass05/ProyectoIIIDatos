package com.example.login.models;

import com.google.gson.annotations.SerializedName;

public class Login {
    @SerializedName("ID")
    String ID;

    @SerializedName("contraseña")
    String contraseña;
    @SerializedName("respuesta")
    Boolean respuesta;

    @SerializedName("Status")
    private int Status;

    @SerializedName("Success")
    private int Success;

    @SerializedName("Status_Message")
    private int Status_Message;


    public Login(String ID, String contraseña) {
        this.ID = ID;
        this.contraseña = contraseña;
    }

    public String getName() {
        return ID;
    }

    public void setNombre(String nombre) {
        this.ID = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Boolean getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Boolean respuesta) {
        this.respuesta = respuesta;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public int getSuccess() {
        return Success;
    }

    public void setSuccess(int success) {
        Success = success;
    }

    public int getStatus_Message() {
        return Status_Message;
    }

    public void setStatus_Message(int status_Message) {
        Status_Message = status_Message;
    }
}
