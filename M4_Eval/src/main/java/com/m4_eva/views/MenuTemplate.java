package com.m4_eva.views;

import java.util.Scanner;

public abstract class MenuTemplate {
    protected Scanner scanner = new Scanner(System.in);

    public abstract void exportarDatos();

    public abstract void crearAlumno();

    public abstract void agregarMateria();

    public abstract void agregarNotaPasoUno();

    public abstract void listarAlumnos();

    public abstract void terminarPrograma();
}

