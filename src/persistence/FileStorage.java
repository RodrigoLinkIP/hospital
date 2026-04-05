package persistence;

import model.Doctor;
import model.MedicalRecord;
import model.Patient;
import service.DoctorService;
import model.Appointment;
import java.util.ArrayList;
import java.util.List;

public class FileStorage {
    private List<MedicalRecord> medicalRecords = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();
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
}