module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    exports com.example.controller;
    opens com.example.controller to javafx.fxml;
}