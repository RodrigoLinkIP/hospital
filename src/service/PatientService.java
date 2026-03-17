package service;

import model.Patient;
import java.util.ArrayList;
import java.util.List;

public class PatientService {
    private List<Patient> pacientes = new ArrayList<>();
    private int contadorId = 1;

    public Patient registrarPaciente(String nombre, String apellido, String fechaNacimiento, String telefono) {
        Patient paciente = new Patient(contadorId++, nombre, apellido, fechaNacimiento, telefono);
        pacientes.add(paciente);
        return paciente;
    }

    public Patient buscarPorId(int id) {    //para buscar a los pacientes
        for (Patient p : pacientes) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;    //si no lo encuentra retorna un null, sofi ahi lo podes cambiar o te puede dar una idea esta parte
    }

    public List<Patient> getPacientes() {
        return pacientes;
    }
}
