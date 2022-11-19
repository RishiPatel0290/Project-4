package com.example.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ChicagoStyleController implements Initializable {



    @FXML
    private Text chicagoPrice;

    @FXML
    private Text chicagoCrust;


    @FXML
    private RadioButton small;


    @FXML
    private RadioButton medium;


    @FXML
    private RadioButton large;



    @FXML
    private ImageView chicagoPizzaImage = new ImageView();


    @FXML
    private ComboBox<String> chicagoFlavors =  new ComboBox<>();


    @FXML
    private ListView<String> availableChicagoToppings = new ListView<>();


    @FXML
    private ListView<String> selectedToppings = new ListView<>();



    /** *
     *
     * if no flavor is passed then regular image is displayed else relevant img is displayed
     *
     * */

    public void setChicagoPizzaImage(String flavor){
        String imageName;
        if(flavor.equalsIgnoreCase("Deluxe")){
            imageName = "chicagoDeluxe.png";
        }else if (flavor.equalsIgnoreCase("BBQ Chicken")){
            imageName = "chicagoBBQChicken.png";
        }else if (flavor.equalsIgnoreCase("Meatzza")){
            imageName = "chicagoMeatzza.png";
        }else if (flavor.equalsIgnoreCase("Build your own")){ // Build your Own
            imageName = "chicagoBuildYourOwn.png";
        }else{
            imageName = "chicago.png";
        }
        try {
            Image chicago = new Image("file:src/images/"+imageName);
            chicagoPizzaImage.setImage(chicago);
        } catch (Exception e) {
            System.out.println(e.toString());
        }


    }



    /**
     *
     * purpose: to set up  images & combo boxes
     *
     * */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // initalize flavor combo box
        chicagoFlavors.setItems(FXCollections.observableArrayList("Deluxe","BBQ Chicken","Meatzza","Build your own"));

        availableChicagoToppings.getItems().addAll("Sausage",
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




        // set default image
        setChicagoPizzaImage("");

    }

    @FXML
    public void chicagoFlavorPicked(ActionEvent actionEvent){
        // set relevant image based on flavor selected
        String flavorPicked = chicagoFlavors.getValue();
        setChicagoPizzaImage(flavorPicked);
    }




    @FXML
    public void addTopping(ActionEvent actionEvent){

        String selectedTopping = availableChicagoToppings.getSelectionModel().getSelectedItem();
        for(String item : selectedToppings.getItems()){
            boolean found = false;

            if(item.equalsIgnoreCase(selectedTopping)){
                return;
            }


        }
         selectedToppings.getItems().add(selectedTopping);




    }
}
