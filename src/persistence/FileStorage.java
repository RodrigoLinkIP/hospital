package persistence;

import model.Patient;
import model.Doctor;
import model.MedicalRecord;
import service.DoctorService;
import model.Appointment;
import java.util.ArrayList;
import java.util.List;

public class FileStorage {
    private List<MedicalRecord> medicalRecords = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();
    private List<Patient> patients = new ArrayList<>();
    private List<Doctor> doctors = new ArrayList<>();
    private int recordId = 1;

    public MedicalRecord addRecord(int doctorId,int patientId, String date, String description){
        MedicalRecord record = new MedicalRecord(recordId++, doctorId, patientId, date, description);
        medicalRecords.add(record);
        return record;
    }

    public void showMedicalRecords(){
        for(MedicalRecord i : medicalRecords){
            System.out.println(i);
        }
    }

    public void saveAppointment(Appointment appointment){
        appointments.add(appointment);
    }

    public List<Appointment> getAppointments(){
        return appointments;
    }

    public void savePatient(Patient patient) {
        patients.add(patient);
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public List<Doctor> getDoctores() {
        return doctors;
    }

    public void guardarDoctor(Doctor doctor) {
        doctors.add(doctor);
    }
}