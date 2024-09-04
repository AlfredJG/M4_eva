package com.m4_eva.views;

import com.m4_eva.models.Alumno;
import com.m4_eva.models.Materia;
import com.m4_eva.models.MateriaEnum;
import com.m4_eva.services.AlumnoServicio;
import com.m4_eva.services.ArchivoServicio;
import java.util.HashMap;

public class Menu extends MenuTemplate {
    private final AlumnoServicio alumnoServicio = new AlumnoServicio();
    private final ArchivoServicio archivoServicio = new ArchivoServicio();

    public Menu(){
        menuOptions = new HashMap<>();
        menuOptions.put(1, this::crearAlumno);
        menuOptions.put(2, this::listarAlumnos);
        menuOptions.put(3, this::agregarNota);
        menuOptions.put(4, this::exportarDatos);
        menuOptions.put(5, this::terminarPrograma);
    }

    @Override
    public void exportarDatos() {
        archivoServicio.exportarDatos(alumnoServicio.listarAlumnos());
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
        System.out.print("Ingrese el RUT del alumno: ");
        String rut = scanner.nextLine();

        Alumno alumno = alumnoServicio.buscarAlumnoPorRut(rut);
        if (alumno == null){
            System.out.println("Alumno no encontrado en sistema.");
            throw new RuntimeException("Alumno no encontrado en sistema.");
        }

        System.out.println("Seleccione la materia a agregar: ");
        for (MateriaEnum materiaEnum : MateriaEnum.values()){
            System.out.println(materiaEnum.ordinal()+ 1 +"."+ materiaEnum.name());
        }

        int opcion = scanner.nextInt();
        scanner.nextLine();

        if (opcion < 1 || opcion > MateriaEnum.values().length){
            System.out.println("¡Número de materia no válido!");
            throw new RuntimeException("Opción no válida.");
        }

        MateriaEnum materiaSeleccionada = MateriaEnum.values()[opcion - 1];
        Materia materia = new Materia(materiaSeleccionada);

        alumno.agregarMateria(materia);
        System.out.println("Materia agregada a alumno: "+ alumno.getNombre());
    }

    @Override
    public void agregarNota(){
        System.out.println("Ingrese el RUT del alumno: ");
        String rut = scanner.nextLine();

        Alumno alumno = alumnoServicio.buscarAlumnoPorRut(rut);
        if (alumno == null){
            System.out.println("¡Alumno no encontrado!");
            return;
        }

        System.out.println("Seleccione la materia a la cual desea ingresar la nota: ");
        for (int i = 0; i < alumno.getMaterias().size(); i++){
            Materia materia = alumno.getMaterias().get(i);
            System.out.println((i + 1)+" "+materia.getNombre());
        }

        int opcion = scanner.nextInt();
        if (opcion < 1 || opcion > alumno.getMaterias().size()){
            System.out.println("Opción invalida, por favor verificar.");
        }

        Materia materiaSeleccionada = alumno.getMaterias().get(opcion - 1);
        System.out.print("Ingrese el nota: ");
        double nota = scanner.nextDouble();

        materiaSeleccionada.agregarNota(nota);
        System.out.println("Nota agregada exitosamente a alumno: "+ alumno.getNombre()+" "+alumno.getApellido());
    }

    @Override
    public void listarAlumnos(){
        System.out.println("Listado de alumnos: ");
        for (int i = 0; i < alumnoServicio.listarAlumnos().size(); i++){
            System.out.println((i+1)+" - "
                    +alumnoServicio.listarAlumnos().get(i).getNombre()
                    +" "
                    +alumnoServicio.listarAlumnos().get(i).getApellido());
        }
    }

    @Override
    public void terminarPrograma() {
        System.out.println("Ha salido usted del sistema.\n¡Gracias y hasta pronto!");
        System.exit(0);
    }

    public void mostrarMenu() {
        System.out.println("Bienvenido al sistema de gestión de alumnos");
        System.out.println(" Colegio Latinoamericano ");
        System.out.println("¿Qué acción desea realizar?");
        System.out.println("1. Crear alumno");
        System.out.println("2. Listado de Alumnos");
        System.out.println("3. Agregar nota");
        System.out.println("4. Exportar Listado");
        System.out.println("5. Cerrar Programa");
    }

    public void ejecutar(){
        do {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            try {
                int opcion = Integer.parseInt(scanner.nextLine());
                Runnable accion = menuOptions.get(opcion);
                if (accion != null) {
                    accion.run();
                } else {
                    System.out.println("¡Opción inválida! Reintente nuevamente.");
                }
            } catch (Exception e) {
                System.out.println("Por favor, ingrese un número valido.");
            }
        } while (true);

    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.ejecutar();
    }

}
