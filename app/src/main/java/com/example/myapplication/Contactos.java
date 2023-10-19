package com.example.myapplication;

import java.io.Serializable;

public class Contactos implements Serializable {
    private String nombre, direccion, correo;

    public Contactos(String nombre, String direccion, String correo) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCorreo() {
        return correo;
    }
}
