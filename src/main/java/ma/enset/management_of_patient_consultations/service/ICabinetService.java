package ma.enset.management_of_patient_consultations.service;
import ma.enset.management_of_patient_consultations.entities.Consultation;
import ma.enset.management_of_patient_consultations.entities.Patient;

import java.sql.SQLException;
import java.util.List;

public interface ICabinetService {

    void addPatient(Patient patient) ;
    void updatePatient(Patient patient);
    void deletePatient(Patient patient);
    Patient getPatientById(Long id);
    List<Patient> getAllPatients();

    void addConsultation(Consultation consultation);
    void updateConsultation(Consultation consultation);
    void deleteConsultation(Consultation consultation);
    Consultation getConsultationById(Long id);
    List<Consultation> getAllConsultations();

}
