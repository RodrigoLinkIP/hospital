package iu;

import iu.SearchPatient;
import service.PatientService;
import model.Patient;
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

        SearchPatient.buscarPaciente(scanner, service);
        scanner.close();
    }
}

