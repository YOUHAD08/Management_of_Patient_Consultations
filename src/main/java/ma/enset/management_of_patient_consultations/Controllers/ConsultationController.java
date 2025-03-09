package ma.enset.management_of_patient_consultations.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.enset.management_of_patient_consultations.DAO.Consultation_DAO;
import ma.enset.management_of_patient_consultations.DAO.Patient_DAO;
import ma.enset.management_of_patient_consultations.entities.Consultation;
import ma.enset.management_of_patient_consultations.entities.Patient;
import ma.enset.management_of_patient_consultations.service.CabinetService;
import ma.enset.management_of_patient_consultations.service.ICabinetService;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ConsultationController implements Initializable {

    @FXML public DatePicker ConsultationDate;
    @FXML public ComboBox<Patient> ComboPatient;
    @FXML public TextArea TextAreaDescription;
    @FXML public TextField TextFieldConsultation;
    @FXML public TableView<Consultation> TableConsultation;
    @FXML public TableColumn<Consultation,Long> ColumnId;
    @FXML public TableColumn<Consultation, DatePicker> ColumnConsultationDate;
    @FXML public TableColumn<Consultation, TextArea > ColumnDescription;
    @FXML public TableColumn<Consultation,Patient> ColumnPatient;

    private ObservableList<Consultation> consultations = FXCollections.observableArrayList();
    private static ObservableList<Patient> patients = FXCollections.observableArrayList();
    private static ICabinetService cabinetService ;

    public void AddConsultation() {

        LocalDate localDate = ConsultationDate.getValue();
        if (localDate == null) {
            showAlert("Error", "Please fill all the fields.");
            return;
        }

        Date consultationdate = Date.valueOf(localDate);
        String consultationdescription = TextAreaDescription.getText();
        Patient patient = ComboPatient.getSelectionModel().getSelectedItem();
        if (patient == null || consultationdescription.isEmpty()) {
            showAlert("Error", "Please fill all the fields.");
        }
        else {
            Consultation consultation = new Consultation(consultationdate, consultationdescription, patient);
            cabinetService.addConsultation(consultation);
            loadConsultations();
            ConsultationDate.setValue(null);
            TextAreaDescription.clear();
            ComboPatient.setValue(null);
        }
    }

    public void DeleteConsultation() {
        Consultation consultation = TableConsultation.getSelectionModel().getSelectedItem();
        if (consultation == null) {
            showAlert("Consultation not found", "Consultation not found");
        }
        else {
            cabinetService.deleteConsultation(consultation);
            loadConsultations();
        }
    }

    public void SearchConsultation() {
    }

    public void UpdateConsultation() {
    }

    private void loadConsultations() {
        consultations.setAll(cabinetService.getAllConsultations());

    }
    static void loadPatients() {
        patients.setAll(cabinetService.getAllPatients());
    }
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cabinetService = new CabinetService(new Patient_DAO(), new Consultation_DAO());


        patients.setAll(cabinetService.getAllPatients());
        ComboPatient.setItems(patients);


        ColumnId.setCellValueFactory(new PropertyValueFactory<>("Consultation_Id"));
        ColumnConsultationDate.setCellValueFactory(new PropertyValueFactory<>("Consultation_Date"));
        ColumnDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        ColumnPatient.setCellValueFactory(new PropertyValueFactory<>("Patient"));
        consultations.setAll(cabinetService.getAllConsultations());
        TableConsultation.setItems(consultations);
    }
}
