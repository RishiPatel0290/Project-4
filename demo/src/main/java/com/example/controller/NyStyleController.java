package com.example.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class NyStyleController implements Initializable {

    @FXML
    ImageView NyPizzaImage = new ImageView();

    @FXML
    ComboBox<String> nyFlavors = new ComboBox<>();

    @FXML
    ListView<String> availableNyToppings = new ListView<>();

    @FXML
    ListView<String> nySelectedToppings = new ListView<>();


    public void setNyPizzaImage(String flavor) {
        String imageName;
        if(flavor.equalsIgnoreCase("Deluxe")){
            imageName = "nyDeluxe.png";
        }else if (flavor.equalsIgnoreCase("BBQ Chicken")){
            imageName = "nyBBQChicken.png";
        }else if (flavor.equalsIgnoreCase("Meatzza")){
            imageName = "nyMeatzza.png";
        }else if (flavor.equalsIgnoreCase("Build your own")){ // Build your Own
            imageName = "nyBuildYourOwn.png";
        }else{
            imageName = "nyc.png";
        }
        try {
            Image chicago = new Image("file:src/images/"+imageName);
            NyPizzaImage.setImage(chicago);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nyFlavors.setItems(FXCollections.observableArrayList("Deluxe","BBQ Chicken","Meatzza","Build your own"));
        availableNyToppings.getItems().addAll("Sausage",
                "pepperoni",
                "green pepper",
                "onion",
                "mushroom",
                "BBQ chicken",
                "provolone",
                "cheddar",
                "beef",
                "ham",
                "Pineapple",
                "Spinach",
                "Black olives");


        setNyPizzaImage("");
    }

    @FXML
    public void nyFlavorPicked(ActionEvent actionEvent){
        String flavorPicked = nyFlavors.getValue();
        setNyPizzaImage(flavorPicked);

    }

    @FXML
    public void nyAddTopping(ActionEvent actionEvent){
        String selectedTopping = availableNyToppings.getSelectionModel().getSelectedItem();
        for(String item : nySelectedToppings.getItems()){
            boolean found = false;

            if(item.equalsIgnoreCase(selectedTopping)){
                return;
            }

        }
        nySelectedToppings.getItems().add(selectedTopping);

    }




}
