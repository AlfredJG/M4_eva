package com.m4_eva.services;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

public class PromedioServicioImpTest {

    private final PromedioServicioImp promedioServicio = new PromedioServicioImp();

    @Test
    public void calcularPromedioTest() {
        List<Double> notas = Arrays.asList(6.0, 7.0, 5.0, 6.5);
        double resultado = promedioServicio.calcularPromedio(notas);

        assertEquals(6.125, resultado, 0.001);
    }

    @Test
    public void calcularPromedioConListaVaciaTest() {
        List<Double> notas = List.of();
        double resultado = promedioServicio.calcularPromedio(notas);

        assertEquals(0, resultado);
    }

    @Test
    public void calcularPromedioConNullTest() {
        double resultado = promedioServicio.calcularPromedio(null);

        assertEquals(0, resultado);
    }
}

