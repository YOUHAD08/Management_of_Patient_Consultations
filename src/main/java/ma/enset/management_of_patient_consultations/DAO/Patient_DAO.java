package ma.enset.management_of_patient_consultations.DAO;

import ma.enset.management_of_patient_consultations.entities.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Patient_DAO implements IPatient_DAO {
    @Override
    public void Create(Patient patient) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedstatement = connection.prepareStatement("INSERT INTO PATIENTS(First_Name,Last_Name, Tel,Address)" +
                "VALUES (?,?,?,?)");
        preparedstatement.setString(1, patient.getFirst_Name());
        preparedstatement.setString(2, patient.getLast_Name());
        preparedstatement.setString(3, patient.getTel());
        preparedstatement.setString(4, patient.getAddress());
        preparedstatement.executeUpdate();
    }

    @Override
    public void Update(Patient patient) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedstatement = connection.prepareStatement("UPDATE PATIENTS SET First_Name=?,Last_Name=?, Tel=?, Address=? WHERE PATIENT_ID=?");
        preparedstatement.setString(1, patient.getFirst_Name());
        preparedstatement.setString(2, patient.getLast_Name());
        preparedstatement.setString(3, patient.getTel());
        preparedstatement.setString(4, patient.getAddress());
        preparedstatement.setLong(5, patient.getPatient_ID());
    }

    @Override
    public void Delete(Patient patient) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedstatement = connection.prepareStatement("DELETE FROM PATIENTS WHERE PATIENT_ID=?");
        preparedstatement.setLong(1, patient.getPatient_ID());
        preparedstatement.executeUpdate();
    }

    @Override
    public List<Patient> getAll() throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedstatement = connection.prepareStatement("SELECT * FROM PATIENTS ");
        ResultSet resultSet = preparedstatement.executeQuery();
        List<Patient> patients = new ArrayList<>();
        while (resultSet.next()) {
            Patient patient = new Patient();
            patient.setPatient_ID(resultSet.getLong("PATIENT_ID"));
            patient.setFirst_Name(resultSet.getString("First_Name"));
            patient.setLast_Name(resultSet.getString("Last_Name"));
            patient.setTel(resultSet.getString("Tel"));
            patient.setAddress(resultSet.getString("Address"));
            patients.add(patient);
        }
        return patients ;
    }

    @Override
    public Patient getById(Long id) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedstatement = connection.prepareStatement("SELECT * FROM PATIENTS WHERE PATIENT_ID=?");
        preparedstatement.setLong(1, id);
        ResultSet resultSet = preparedstatement.executeQuery();
        Patient patient = new Patient();
        if (resultSet.next()) {
            patient.setPatient_ID(resultSet.getLong("PATIENT_ID"));
            patient.setFirst_Name(resultSet.getString("First_Name"));
            patient.setLast_Name(resultSet.getString("Last_Name"));
            patient.setTel(resultSet.getString("Tel"));
            patient.setAddress(resultSet.getString("Address"));
        }
        return patient;
    }
}
