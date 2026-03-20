package iu;

import model.Doctor;
import service.DoctorService;

import java.util.Scanner;

public class SearchDoctor {
    private DoctorService doctorService;
    private Scanner scanner;

    public SearchDoctor(DoctorService doctorService) {
        this.doctorService = doctorService;
        this.scanner = new Scanner(System.in);
    }

    public void buscarDoctorPorId() {
        System.out.print("Ingrese el ID del doctor: ");
        int id = scanner.nextInt();
        Doctor doctor = doctorService.buscarPorId(id);
        if (doctor != null) {
            System.out.println("Doctor encontrado: " + doctor);
        } else {
            System.out.println("No se encontró un doctor con ese ID.");
        }
    }
}