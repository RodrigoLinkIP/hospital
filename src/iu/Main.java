package iu;

import service.PatientService;
import model.Patient;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PatientService service = new PatientService();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("Fecha de nacimiento: ");
        String fecha = scanner.nextLine();

        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        Patient paciente = service.registrarPaciente(nombre, apellido, fecha, telefono);

        System.out.println("\nPaciente registrado con éxito:");
        System.out.println(paciente);

        // buscar los pacientes
        int opcionBusqueda;
        while (true) {
            System.out.println("\nBuscar paciente por:");
            System.out.println("1. ID");
            System.out.println("2. Nombre");
            System.out.print("Seleccione una opción: ");

            try {
                opcionBusqueda = scanner.nextInt();
                scanner.nextLine();

                if (opcionBusqueda == 1 || opcionBusqueda == 2) {
                    break;
                } else {
                    System.out.println("Opción inválida. Intente de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error: Ingresa un número válido.");
                scanner.nextLine();
            }
        }

        if (opcionBusqueda == 1) {
            int idBuscar;

            while (true) {
                System.out.print("\nIngrese el ID: ");
                try {
                    idBuscar = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } catch (Exception e) {
                    System.out.println("Debe ingresar un número válido.");
                    scanner.nextLine();
                }
            }

            Patient encontrado = service.buscarPorId(idBuscar);
            if (encontrado != null) {
                System.out.println("\nPaciente encontrado:");
                System.out.println(encontrado);
            } else {
                System.out.println("Paciente no encontrado");
            }
        } else if (opcionBusqueda == 2) {
            System.out.print("\nIngrese el nombre: ");
            String buscarNombre = scanner.nextLine();

            List<Patient> resultados = service.buscarporNombre(buscarNombre);

            if (resultados.isEmpty()) {
                System.out.println("No se encontraron pacientes");
            } else {
                System.out.println("\nPaciente encontrado:");
                for (Patient p : resultados) {
                    System.out.println(p);
                }
            }
        } else {
            System.out.println("Opción inválida.");
        }
    }
}

