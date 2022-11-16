package com.example.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ChicagoStyleController implements Initializable {

    @FXML
    ImageView chicagoPizzaImage;


    /**
     *
     * purpose: to set up  images
     *
     * */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {

            Image chicago = new Image("file:src/images/chicago.png");
            chicagoPizzaImage.setImage(chicago);
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }
}
