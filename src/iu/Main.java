package iu;

import persistence.FileStorage;
import service.PatientService;
import service.DoctorService;
import model.Patient;
import model.Doctor;
import model.Appointment;
import model.MedicalRecord;
import java.util.Scanner;
import service.AppointmentService;

import javax.swing.plaf.synth.SynthTextAreaUI;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PatientService patientService = new PatientService();
        DoctorService doctorService = new DoctorService();
        SearchDoctor searchDoctor = new SearchDoctor(doctorService);
        AppointmentService appointmentService = new AppointmentService();
        FileStorage storage = new FileStorage();

        int opcion;
        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Registrar Paciente");
            System.out.println("2. Buscar Paciente");
            System.out.println("3. Registrar Doctor");
            System.out.println("4. Buscar Doctor por ID");
            System.out.println("5. Listar Doctores");
            System.out.println("6. Crear cita");
            System.out.println("7. Ver citas");
            System.out.println("8. Agregar nota medica");
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

                case 6:
                    System.out.print("ID del paciente: ");
                    int idPaciente = scanner.nextInt();
                    scanner.nextLine();

                    Patient pacienteCita = patientService.buscarPorId(idPaciente);

                    if (pacienteCita == null) {
                        System.out.println("Paciente no encontrado");
                        break;
                    }

                    System.out.print("ID del doctor: ");
                    int idDoctor = scanner.nextInt();
                    scanner.nextLine();

                    Doctor doctorCita = doctorService.buscarPorId(idDoctor);

                    if (doctorCita == null) {
                        System.out.println("Doctor no encontrado");
                        break;
                    }

                    System.out.print("Fecha: ");
                    String fechaCita = scanner.nextLine();

                    System.out.print("Hora: ");
                    String hora = scanner.nextLine();

                    Appointment nuevaCita = appointmentService.crearCita(pacienteCita, doctorCita, fechaCita, hora);

                    if (nuevaCita != null) {
                        System.out.println("Cita creada:");
                        System.out.println(nuevaCita);
                    }

                    break;

                case 7:
                    for (Appointment c : storage.getAppointments()) {
                        System.out.println(c);
                        System.out.println("-----------");
                    }
                    break;

                case 8:
                    System.out.print("Estos son los medicos disponibles:");
                    for (Doctor d : doctorService.getDoctores()) {
                        System.out.println(d);
                    }
                    System.out.print("Ingrese el ID del doctor que desees usar:");
                    int docId = scanner.nextInt();

                    System.out.println("Estos son los pacientes disponibles:");
                    patientService.mostrarPacientes();

                    System.out.println("Ingrese el ID del paciente al que le desee agregar una nota médica:");
                    int patientId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Ingrese la descripción medica del paciente:");
                    String description = scanner.nextLine();

                    System.out.print("Ingrese la fecha:");
                    String date = scanner.nextLine();
                    MedicalRecord record = storage.addRecord(docId, patientId, date, description);
                    break;

                case 9:
                    storage.showMedicalRecords();
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
