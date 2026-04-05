package service;

import model.Appointment;
import model.Patient;
import model.Doctor;
import persistence.FileStorage;

import java.util.ArrayList;

public class AppointmentService {

    private ArrayList<Appointment> citas = new ArrayList<>();
    private int contadorId = 1;

    private FileStorage storage = new FileStorage();

    public Appointment crearCita(Patient patient, Doctor doctor, String fecha, String hora) {

        for (Appointment c : citas) {
            if (c.getFecha().equals(fecha) && c.getHora().equals(hora)) {
                System.out.println("Ya existe una cita en esa fecha y hora.");
                return null;
            }
        }

        Appointment cita = new Appointment(contadorId++, patient, doctor, fecha, hora);
        citas.add(cita);

        storage.saveAppointment(cita);

        return cita;
    }

    public ArrayList<Appointment> getCitas() {
        return citas;
    }
}