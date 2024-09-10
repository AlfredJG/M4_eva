package com.m4_eva.services;

import com.m4_eva.models.Alumno;
import com.m4_eva.models.Materia;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ArchivoServicio {
    public void exportarDatos(List<Alumno> alumnos){

        try(FileWriter writer = new FileWriter("listado_alumnos.txt")){
            for (Alumno alumno : alumnos) {
                writer.write("Alumno: "+alumno.getRut()+" - "+alumno.getNombre()+" "+alumno.getApellido()+"\n");
                for (Materia materia : alumno.getMaterias()){
                    writer.write(" Materia: "+ materia.getNombre()+" - Promedio "+ materia.getPromedio()+"\n");
                }
            }
            System.out.println("¡Datos exportados exitosamente!");
        } catch(IOException e){
            System.out.println("Error al exportar datos: "+e.getMessage());
        }
    }
}
