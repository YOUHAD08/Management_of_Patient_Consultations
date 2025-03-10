package ma.enset.management_of_patient_consultations.DAO;

import ma.enset.management_of_patient_consultations.entities.Consultation;
import ma.enset.management_of_patient_consultations.entities.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Consultation_DAO implements IConsultation_DAO {
    @Override
    public void Create(Consultation consultation) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedstatement = connection.prepareStatement("INSERT INTO consultation(Consultation_Date ,Description, PatientId)" +
                "VALUES (?,?,?)");
        preparedstatement.setDate(1, consultation.getConsultation_Date());
        preparedstatement.setString(2, consultation.getDescription());
        preparedstatement.setLong(3, consultation.getPatient().getPatient_ID());
        preparedstatement.executeUpdate();
    };

    @Override
    public void Update(Consultation consultation) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedstatement = connection.prepareStatement("UPDATE Consultation SET Consultation_Date=?,Description=?, PatientId=? WHERE Consultation_Id=?");
        preparedstatement.setDate(1, consultation.getConsultation_Date());
        preparedstatement.setString(2, consultation.getDescription());
        preparedstatement.setLong(3, consultation.getPatient().getPatient_ID());
        preparedstatement.setLong(4, consultation.getConsultation_Id());
        preparedstatement.executeUpdate();
    }

    @Override
    public void Delete(Consultation consultation) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedstatement = connection.prepareStatement("DELETE * FROM Consultation WHERE Consultation_Id=?");
        preparedstatement.setLong(1, consultation.getConsultation_Id());
        preparedstatement.executeUpdate();

    }

    @Override
    public List<Consultation> getAll() throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedstatement = connection.prepareStatement("SELECT * FROM Consultation ");
        ResultSet resultSet = preparedstatement.executeQuery();
        List<Consultation> consultations = new ArrayList<>();
        Patient_DAO patient_DAO = new Patient_DAO();
        while (resultSet.next()) {
            Consultation consultation = new Consultation();
            consultation.setConsultation_Id(resultSet.getLong("Consultation_Id"));
            consultation.setConsultation_Date(resultSet.getDate("Consultation_Date"));
            consultation.setDescription(resultSet.getString("Description"));
            long PatientIndex = resultSet.getLong("PatientId");
            consultation.setPatient(patient_DAO.getById(PatientIndex));

            consultations.add(consultation);
        }
        return consultations ;
    }

    @Override
    public Consultation getById(Long id) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedstatement = connection.prepareStatement("SELECT * FROM Consultation WHERE Consultation_ID=?");
        preparedstatement.setLong(1, id);
        ResultSet resultSet = preparedstatement.executeQuery();
        Consultation consultation = new Consultation();
        Patient_DAO patient_DAO = new Patient_DAO();
        if (resultSet.next()) {
            consultation.setConsultation_Id(resultSet.getLong("Consultation_Id"));
            consultation.setConsultation_Date(resultSet.getDate("Consultation_Date"));
            consultation.setDescription(resultSet.getString("Description"));
            long PatientIndex = resultSet.getLong("PatientId");
            consultation.setPatient(patient_DAO.getById(PatientIndex));
        }
        return consultation;
    }
}
