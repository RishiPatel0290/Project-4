module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    exports com.example.controller;
    opens com.example.controller to javafx.fxml;
}