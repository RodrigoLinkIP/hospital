package iu;

import service.PatientService;
import service.DoctorService;
import model.Patient;
import model.Doctor;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PatientService patientService = new PatientService();
        DoctorService doctorService = new DoctorService();
        SearchDoctor searchDoctor = new SearchDoctor(doctorService);

        int opcion;
        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Registrar Paciente");
            System.out.println("2. Buscar Paciente");
            System.out.println("3. Registrar Doctor");
            System.out.println("4. Buscar Doctor por ID");
            System.out.println("5. Listar Doctores");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Fecha de nacimiento: ");
                    String fecha = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();

                    Patient paciente = patientService.registrarPaciente(nombre, apellido, fecha, telefono);
                    System.out.println("\nPaciente registrado con éxito:");
                    System.out.println(paciente);
                    break;

                case 2:
                    SearchPatient.buscarPaciente(scanner, patientService);
                    break;

                case 3:
                    System.out.print("Nombre: ");
                    String nombreDoc = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellidoDoc = scanner.nextLine();
                    System.out.print("Fecha de nacimiento: ");
                    String fechaDoc = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefonoDoc = scanner.nextLine();
                    System.out.print("Especialidad: ");
                    String especialidad = scanner.nextLine();
                    System.out.print("Licencia: ");
                    String licencia = scanner.nextLine();

                    Doctor nuevo = doctorService.registrarDoctor(nombreDoc, apellidoDoc, fechaDoc,
                            telefonoDoc, especialidad, licencia);
                    if (nuevo != null) {
                        System.out.println("Doctor registrado: " + nuevo);
                    }
                    break;

                case 4:
                    searchDoctor.buscarDoctorPorId();
                    break;

                case 5:
                    System.out.println("Lista de doctores:");
                    for (Doctor d : doctorService.getDoctores()) {
                        System.out.println(d);
                    }
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
