module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires junit;
    exports com.example.controller;
    exports test;
    opens com.example.controller to javafx.fxml;
}