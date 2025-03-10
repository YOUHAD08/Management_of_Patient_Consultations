package ma.enset.management_of_patient_consultations.DAO;

import ma.enset.management_of_patient_consultations.entities.Patient;

import java.sql.SQLException;
import java.util.List;

public interface IPatient_DAO extends IGeneric_DAO<Patient, Long> {
    List<Patient> searchByQuery(String query) throws SQLException;

}
