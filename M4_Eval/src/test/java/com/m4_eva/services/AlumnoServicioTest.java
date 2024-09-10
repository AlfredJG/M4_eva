// src/test/java/com/m4_eva/services/AlumnoServicioTest.java
package com.m4_eva.services;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class AlumnoServicioTest {

    @Test
    public void testCrearAlumno() {
        AlumnoServicio alumnoServicio = Mockito.mock(AlumnoServicio.class);
        alumnoServicio.crearAlumno("12345678-9", "Juan", "Perez", "Calle Falsa 123");
        Mockito.verify(alumnoServicio).crearAlumno("12345678-9", "Juan", "Perez", "Calle Falsa 123");
    }
}
