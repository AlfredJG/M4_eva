package com.m4_eva.models;

import com.m4_eva.services.PromedioServicioImp;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    private MateriaEnum nombre;
    private List<Double> notas;
    private double promedio;

    // Servicio para calcular el promedio
    private final PromedioServicioImp promedioServicio;

    public Materia(MateriaEnum nombre) {
        this.nombre = nombre;
        this.notas = new ArrayList<>();
        this.promedioServicio = new PromedioServicioImp();
    }

    public MateriaEnum getNombre() {
        return nombre;
    }

    public void setNombre(MateriaEnum nombre) {
        this.nombre = nombre;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public void agregarNota(double nota) {
        this.notas.add(nota);
        this.promediarNotas();
    }

    public void promediarNotas() {
        this.promedio = promedioServicio.calcularPromedio(this.notas);
    }
}
