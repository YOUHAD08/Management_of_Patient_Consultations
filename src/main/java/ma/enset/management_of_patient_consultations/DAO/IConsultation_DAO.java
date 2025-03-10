package ma.enset.management_of_patient_consultations.DAO;

import ma.enset.management_of_patient_consultations.entities.Consultation;
import java.sql.SQLException;
import java.util.List;

public interface IConsultation_DAO extends IGeneric_DAO<Consultation, Long> {
    List<Consultation> searchByQuery(String query) throws SQLException;
}
