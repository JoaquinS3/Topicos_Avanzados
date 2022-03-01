module com.example.primeapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.primeapp to javafx.fxml;
    exports com.example.primeapp;
}