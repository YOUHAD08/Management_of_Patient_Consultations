package ma.enset.management_of_patient_consultations.entities;

import java.util.List;

public class Patient {
    private long Patient_ID;
    private String First_Name;
    private String Last_Name;
    private String Tel;
    private String 	Address;
    private List<Consultation> Consultations;

    public Patient() {
    }

    public Patient(String first_Name, String last_Name, String tel, String address) {
        First_Name = first_Name;
        Last_Name = last_Name;
        Tel = tel;
        Address = address;
    }

    public long getPatient_ID() {
        return Patient_ID;
    }

    public void setPatient_ID(long patient_ID) {
        Patient_ID = patient_ID;
    }

    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String first_Name) {
        First_Name = first_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String last_Name) {
        Last_Name = last_Name;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "Patient_ID=" + Patient_ID +
                ", First_Name='" + First_Name + '\'' +
                ", Last_Name='" + Last_Name + '\'' +
                ", Tel='" + Tel + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }

    public List<Consultation> getConsultations() {
        return Consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        Consultations = consultations;
    }
}
