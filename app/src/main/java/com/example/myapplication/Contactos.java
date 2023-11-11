package com.example.myapplication;

import java.io.Serializable;

public class Contactos implements Serializable {
    private int id;
    private String nombre, direccion, correo;

    public Contactos() {
    }

    public Contactos(String nombre, String direccion, String correo) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
    }

    public int getId() {
        return id;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
