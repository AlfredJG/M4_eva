package com.m4_eva.services;

import com.m4_eva.models.Alumno;
import java.util.ArrayList;
import java.util.List;

public class AlumnoServicio {
    private List<Alumno> alumnos;

    public AlumnoServicio() {
        this.alumnos = new ArrayList<>();
    }

    public void crearAlumno(String rut, String nombre, String apellido, String direccion){
        Alumno alumno = new Alumno(rut, nombre, apellido, direccion);
        alumnos.add(alumno);

    }

    public List<Alumno> listarAlumnos(){
        return alumnos;
    }

    public Alumno buscarAlumnoPorRut(String rut){
        return alumnos.stream().filter(alumno -> alumno.getRut().equals(rut)).findFirst().orElse(null);
    }

}
