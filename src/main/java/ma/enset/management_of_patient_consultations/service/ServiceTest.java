package ma.enset.management_of_patient_consultations.service;

import ma.enset.management_of_patient_consultations.DAO.Consultation_DAO;
import ma.enset.management_of_patient_consultations.DAO.Patient_DAO;
import ma.enset.management_of_patient_consultations.entities.Consultation;
import ma.enset.management_of_patient_consultations.entities.Patient;
import java.util.List;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ServiceTest {
    public static void main(String[] args) throws SQLException, ParseException {
        ICabinetService cabinetService = new CabinetService(new Patient_DAO(), new Consultation_DAO());

        // cabinetService.addPatient(new Patient("Ayoub","Youhad","0696376139","Taheenoauet"));
        // cabinetService.addPatient(new Patient("khalid","Zain","0696376230","Casablanca"));

        //Patient patient = cabinetService.getPatientById(1L);
        // Patient patient = cabinetService.getPatientById(2L)


        // SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        // java.util.Date utilDate = sdf.parse("09-03-2025");
        // java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime())Patient patient = cabinetService.getPatientById(2L)

        // cabinetService.addConsultation(new Consultation(sqlDate,"Stays for the night ",patient));
        List<Patient> patients = cabinetService.getAllPatients();
        patients.forEach(patient -> {System.out.println(patient.toString());});




    }
}
