package model;

public class MedicalRecord {
    private int recordId;
    private int patientId;
    private int doctorId;
    private String date;
    private String description;

    public MedicalRecord(int recordId, int doctorId, int patientId, String date, String description){
        this.recordId = recordId;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.date = date;
        this.description = description;
    }

    public int getRecordId() { return recordId; }
    public int getDoctorId() { return doctorId; }
    public int getPatientId() { return patientId; }
    public String getDate() { return date; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return "Record ID: " + recordId + "\n" +
                "Doctor ID: " + doctorId + "\n" +
                "Patient ID: " + patientId + "\n" +
                "Date: " + date + "\n" +
                "Description: " + description + "\n";
    }

}
