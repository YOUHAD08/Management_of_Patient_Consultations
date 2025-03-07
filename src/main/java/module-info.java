module ma.enset.management_of_patient_consultations {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens ma.enset.management_of_patient_consultations to javafx.fxml;
    exports ma.enset.management_of_patient_consultations;
}