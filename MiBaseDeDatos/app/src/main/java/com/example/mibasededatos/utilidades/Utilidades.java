package com.example.mibasededatos.utilidades;

public class Utilidades {
    //Declarar nombre de tablas y campos
    public static final String TABLA_EMPLEADOS = "empleados";
    public static final String CAMPO_CLAVE = "clave";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_SUELDO = "sueldo";

    //Crear constante
    public static final String CREARTABLA_EMPLEADOS ="CREATE TABLE " + TABLA_EMPLEADOS + " " + "(" + CAMPO_CLAVE  + " INTEGER," + CAMPO_NOMBRE + " TEXT," + CAMPO_SUELDO + " FLOAT)";
}
