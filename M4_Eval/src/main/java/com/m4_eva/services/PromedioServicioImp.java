package com.m4_eva.services;

import java.util.List;

public class PromedioServicioImp {
    public double calcularPromedio(List<Double> notas){
        if (notas == null || notas.isEmpty()){
            return 0;
        }

        double sumatoriaNotas = 0;
        for (Double nota : notas){
            sumatoriaNotas += nota;
        }

        return sumatoriaNotas/notas.size();
    }
}
