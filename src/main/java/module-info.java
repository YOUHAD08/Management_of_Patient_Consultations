module ma.enset.management_of_patient_consultations {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens ma.enset.management_of_patient_consultations.Controllers to javafx.fxml;
    opens ma.enset.management_of_patient_consultations.entities to javafx.base;
    exports ma.enset.management_of_patient_consultations;
}