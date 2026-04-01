package model;

public class Appointment {
    private int id;
    private Patient patient;
    private Doctor doctor;
    private String fecha;
    private String hora;

    public Appointment(int id, Patient patient, Doctor doctor, String fecha, String hora) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    @Override
    public String toString() {
        return "Cita ID: " + id +
                "\nPaciente: " + patient.getNombre() + " " + patient.getApellido() +
                "\nDoctor: " + doctor.getNombre() + " " + doctor.getApellido() +
                "\nFecha: " + fecha +
                "\nHora: " + hora;
    }
}