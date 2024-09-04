package com.m4_eva.views;

import com.m4_eva.services.AlumnoServicio;
import com.m4_eva.services.ArchivoServicio;

public class Menu extends MenuTemplate {
    private AlumnoServicio alumnoServicio = new AlumnoServicio();
    private ArchivoServicio archivoServicio = new ArchivoServicio();

    @Override
    public void exportarDatos(){
        System.out.println("Exportar data...");
    }

    @Override
    public void crearAlumno(){
        System.out.print("Ingrese el RUT del alumno: ");
        String rut = scanner.nextLine();
        System.out.print("Ingrese el nombre del alumno: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido del alumno: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese la dirección del alumno: ");
        String direccion = scanner.nextLine();

        alumnoServicio.crearAlumno(rut, nombre, apellido, direccion);
        System.out.println("¡Alumno creado correctamente!");
    }

    @Override
    public void agregarMateria(){
        System.out.println("Agregar materia...");
    }

    @Override
    public void agregarNotaPasoUno(){
        System.out.println("Agregar nota...");
    }

    @Override
    public void listarAlumnos(){
        System.out.println("Listado de alumnos: ");
        alumnoServicio.listarAlumnos()
                .forEach(alumno ->
                System.out.println(alumno.getNombre() + " " + alumno.getApellido()));
    }

    @Override
    public void terminarPrograma(){
        System.out.println("Terminar programa...");
        System.exit(0);
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.crearAlumno();
        menu.listarAlumnos();
    }
}
