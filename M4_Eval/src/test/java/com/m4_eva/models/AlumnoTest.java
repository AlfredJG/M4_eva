package com.m4_eva.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlumnoTest {

    @Test
    public void testCrearAlumno() {
        Alumno alumno = new Alumno("12345678-9", "Juan", "Perez", "Calle Falsa 123");

        // Asegúrate de usar assertEquals de org.junit.jupiter.api.Assertions
        assertEquals("Juan", alumno.getNombre());
        assertEquals("Perez", alumno.getApellido());
        assertEquals("12345678-9", alumno.getRut());
        assertEquals("Calle Falsa 123", alumno.getDireccion());
    }
}
