package ma.enset.management_of_patient_consultations.service;

import ma.enset.management_of_patient_consultations.DAO.IConsultation_DAO;
import ma.enset.management_of_patient_consultations.DAO.IPatient_DAO;
import ma.enset.management_of_patient_consultations.entities.Consultation;
import ma.enset.management_of_patient_consultations.entities.Patient;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CabinetService implements ICabinetService {

    private IPatient_DAO patient_DAO;
    private IConsultation_DAO consultation_DAO;

    public CabinetService(IPatient_DAO patient_DAO, IConsultation_DAO consultation_DAO) {
        this.patient_DAO = patient_DAO;
        this.consultation_DAO = consultation_DAO;
    }


    @Override
    public void addPatient(Patient patient)  {
        try {
            patient_DAO.Create(patient);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updatePatient(Patient patient) {
        try {
            patient_DAO.Update(patient);
        } catch (SQLException e) {
            e.printStackTrace();;
        }

    }

    @Override
    public void deletePatient(Patient patient) {
        try {
            patient_DAO.Delete(patient);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Patient getPatientById(Long id) {
        Patient patient = new Patient();
        try {
            patient= patient_DAO.getById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patient;
    }

    @Override
    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<Patient>();
        try {
            patients = patient_DAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }

    @Override
    public List<Patient> searchPatientByQuery(String query) {
        List<Patient> patients = new ArrayList<Patient>();
        try {
            patients = patient_DAO.searchByQuery(query);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return patients ;
    }

    @Override
    public void addConsultation(Consultation consultation) {
        try {
            consultation_DAO.Create(consultation);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void updateConsultation(Consultation consultation) {
        try {
            consultation_DAO.Update(consultation);
        } catch (SQLException e) {
            e.printStackTrace();;
        }

    }

    @Override
    public void deleteConsultation(Consultation consultation) {
        try {
            consultation_DAO.Delete(consultation);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Consultation getConsultationById(Long id) {
        Consultation consultation = new Consultation();
        try {
            consultation= consultation_DAO.getById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consultation;

    }

    @Override
    public List<Consultation> getAllConsultations() {
        List<Consultation> consultations = new ArrayList<Consultation>();
        try {
            consultations  = consultation_DAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consultations;
    }

    public List<Consultation> searchConsultationByQuery(String query) {
        List<Consultation> consultations = new ArrayList<Consultation>();
        try {
            consultations = consultation_DAO.searchByQuery(query);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return consultations ;
    }
}
