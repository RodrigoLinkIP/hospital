package service;

import model.Patient;
import persistence.FileStorage;
import java.util.ArrayList;
import java.util.List;

public class PatientService {
    private FileStorage storage = new FileStorage();
    private int contadorId = 1;

    public Patient registrarPaciente(String nombre, String apellido, String fechaNacimiento, String telefono) {
        Patient paciente = new Patient(contadorId++, nombre, apellido, fechaNacimiento, telefono);
        storage.savePatient(paciente);
        return paciente;
    }

    public Patient buscarPorId(int id) {    //para buscar a los pacientes
        for (Patient p : storage.getPatients()) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;    //si no lo encuentra retorna un null,
    }

    public List<Patient> buscarporNombre (String nombre) {
        List<Patient> resultados = new ArrayList<>();
        for (Patient p : storage.getPatients()) {
            if(p.getNombre().equalsIgnoreCase(nombre)) {
                resultados.add(p);
            }
        }
        return resultados;
    }

    public void mostrarPacientes() {
        for (Patient p : storage.getPatients()) {
            System.out.println(p);
        }
    }


    public List<Patient> getPacientes() {
        return storage.getPatients();
    }
}
