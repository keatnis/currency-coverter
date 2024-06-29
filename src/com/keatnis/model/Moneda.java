package com.keatnis.model;

public class Moneda {

    private String clave;
    private String nombre;


    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String toString() {
        return "Moneda{" +
                "clave='" + clave + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }

}
