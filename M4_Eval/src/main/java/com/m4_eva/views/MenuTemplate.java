package com.m4_eva.views;

import java.util.Map;
import java.util.Scanner;

public abstract class MenuTemplate {
    protected static Scanner scanner = new Scanner(System.in);
    protected Map<Integer, Runnable> menuOptions;

    public abstract void exportarDatos();

    public abstract void crearAlumno();

    public abstract void agregarMateria();

    public abstract void agregarNota();

    public abstract void listarAlumnos();

    public abstract void terminarPrograma();

}

