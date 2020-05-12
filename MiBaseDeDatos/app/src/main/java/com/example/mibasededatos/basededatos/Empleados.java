package com.example.mibasededatos.basededatos;

public class Empleados {
    private Integer clave;
    private String nombre;
    private Float sueldo;

    public Empleados() {
    }

    public Empleados(Integer clave, String nombre, Float sueldo) {
        this.clave = clave;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    public Integer getClave() {
        return clave;
    }

    public void setClave(Integer clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getSueldo() {
        return sueldo;
    }

    public void setSueldo(Float sueldo) {
        this.sueldo = sueldo;
    }
}
