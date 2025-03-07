package ma.enset.management_of_patient_consultations.entities;


import java.sql.Date;

public class Consultation {
    private int Consultation_Id;
    private Date Consultation_Date;
    private String Description;
    private Patient Patient;

    public Consultation() {
    }


    public Consultation(Date consultation_Date, String description, ma.enset.management_of_patient_consultations.entities.Patient patient) {
        Consultation_Date = consultation_Date;
        Description = description;
        Patient = patient;
    }

    public int getConsultation_Id() {
        return Consultation_Id;
    }

    public void setConsultation_Id(int consultation_Id) {
        Consultation_Id = consultation_Id;
    }

    public Date getConsultation_Date() {
        return Consultation_Date;
    }

    public void setConsultation_Date(Date consultation_Date) {
        Consultation_Date = consultation_Date;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Patient getPatient() {
        return Patient;
    }

    public void setPatient(Patient patient) {
        Patient = patient;
    }
}
