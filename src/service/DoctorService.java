package service;

import model.Doctor;
import persistence.FileStorage;  // Importa la clase FileStorage
import java.util.List;

public class DoctorService {
    private FileStorage storage = new FileStorage();
    private int contadorId = 1;

    public Doctor registrarDoctor(String nombre, String apellido, String fechaNacimiento,
                                  String telefono, String especialidad, String licencia) {
        if (nombre.isEmpty() || apellido.isEmpty() || especialidad.isEmpty() || licencia.isEmpty()) {
            System.out.println("Todos los campos son obligatorios.");
            return null;
        }


        for (Doctor d : storage.getDoctores()) {
            if (d.getLicencia().equalsIgnoreCase(licencia)) {
                System.out.println("Ya existe un doctor con esa licencia.");
                return null;
            }
        }

        Doctor doctor = new Doctor(contadorId++, nombre, apellido, fechaNacimiento, telefono, especialidad, licencia);
        storage.guardarDoctor(doctor);
        return doctor;
    }

    public Doctor buscarPorId(int id) {
        for (Doctor d : storage.getDoctores()) {
            if (d.getId() == id) {
                return d;
            }
        }
        return null;
    }

    public List<Doctor> getDoctores() {
        return storage.getDoctores();
    }
}
