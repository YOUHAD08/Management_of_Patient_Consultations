package ma.enset.management_of_patient_consultations.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.enset.management_of_patient_consultations.DAO.Consultation_DAO;
import ma.enset.management_of_patient_consultations.DAO.Patient_DAO;
import ma.enset.management_of_patient_consultations.entities.Patient;
import ma.enset.management_of_patient_consultations.service.CabinetService;
import ma.enset.management_of_patient_consultations.service.ICabinetService;

import java.net.URL;
import java.util.ResourceBundle;

public class PatientController implements Initializable {
    @FXML public TextField TextFieldFirstName;
    @FXML public TextField TextFieldLastName;
    @FXML public TextField TextFieldTel;
    @FXML public TextField TextFieldAddress;
    @FXML public TextField TextFieldSearch;
    @FXML public TableView<Patient> tablePatients;
    @FXML public TableColumn<Patient,Long> ColumnId;
    @FXML public TableColumn<Patient,String> ColumnFirstName;
    @FXML public TableColumn<Patient,String> ColumnLastName;
    @FXML public TableColumn<Patient,String> ColumnTel;
    @FXML public TableColumn<Patient,String> ColumnAddress;
    //Model
    private ObservableList<Patient> patients = FXCollections.observableArrayList();
    private ICabinetService cabinetService ;
    private Patient selectedPatient;


    public void AddPatient() {
        String firstName = TextFieldFirstName.getText();
        String lastName = TextFieldLastName.getText();
        String tel = TextFieldTel.getText();
        String address = TextFieldAddress.getText();


        if (firstName.isEmpty() || lastName.isEmpty() || tel.isEmpty() || address.isEmpty()) {
            showAlert("Error", "Please fill all the fields");

        }
        else {
            Patient patient = new Patient(firstName,lastName,tel,address);
            cabinetService.addPatient(patient);
            loadPatients();
            TextFieldFirstName.clear();
            TextFieldLastName.clear();
            TextFieldTel.clear();
            TextFieldAddress.clear();
        }
    }

    public void DeletePatient(ActionEvent actionEvent) {
        Patient patient = tablePatients.getSelectionModel().getSelectedItem();
        if (patient == null) {
            showAlert("Patient not found", "Please select a Patient");
        }
        else {
            cabinetService.deletePatient(patient);
            loadPatients();
        }
    }

    public void SearchPatient(ActionEvent actionEvent) {
    }

    public void UpdatePatient() {

        selectedPatient.setFirst_Name(TextFieldFirstName.getText());
        selectedPatient.setLast_Name(TextFieldLastName.getText());
        selectedPatient.setTel(TextFieldTel.getText());
        selectedPatient.setAddress(TextFieldAddress.getText());
        System.out.println(selectedPatient);

        cabinetService.updatePatient(selectedPatient);

        loadPatients();
    }

    private void loadPatients() {
        patients.setAll(cabinetService.getAllPatients());
        ConsultationController.loadPatients();
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
        ColumnId.setCellValueFactory(new PropertyValueFactory<>("Patient_ID"));
        ColumnFirstName.setCellValueFactory(new PropertyValueFactory<>("First_Name"));
        ColumnLastName.setCellValueFactory(new PropertyValueFactory<>("Last_Name"));
        ColumnTel.setCellValueFactory(new PropertyValueFactory<>("Tel"));
        ColumnAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        patients.setAll(cabinetService.getAllPatients());
        tablePatients.setItems(patients);
        TextFieldSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            patients.setAll(cabinetService.searchPatientByQuery(newValue)) ;
        });
        tablePatients.getSelectionModel().selectedItemProperty().addListener((observable, oldValuePatient, newValuePatient) -> {
            if(newValuePatient != null) {
                TextFieldFirstName.setText(newValuePatient.getFirst_Name());
                TextFieldLastName.setText(newValuePatient.getLast_Name());
                TextFieldTel.setText(newValuePatient.getTel());
                TextFieldAddress.setText(newValuePatient.getAddress());
                selectedPatient=newValuePatient;
            }
        });
    }
}

