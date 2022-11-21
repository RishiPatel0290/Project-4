package com.example.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class NyStyleController implements Initializable {

    @FXML
    private Button nyAddToOrder;

    @FXML
    private Button nyAddButton;

    @FXML
    private Button nyRemoveButton;
    @FXML
    private TextField nyPrice;


    @FXML
    private TextField nyCrust;


    @FXML
    private RadioButton nySmall;



    @FXML
    private RadioButton nyMedium;


    @FXML
    private RadioButton nyLarge;

    @FXML
    private ImageView NyPizzaImage = new ImageView();

    @FXML
    private ComboBox<String> nyFlavors = new ComboBox<>();

    @FXML
    private ListView<String> availableNyToppings = new ListView<>();

    @FXML
    private ListView<String> nySelectedToppings = new ListView<>();


    private PizzaFactory pizzaFactory = new NYPizza();


    // this will be added to list of order
    private Pizza pizza;


    private void updatePrice() {
        nyPrice.setText(Double.toString(pizza.price()));
    }

    private Size getSize(){
        if(nySmall.isSelected()){
            return Size.SMALL;
        }else if (nyMedium.isSelected()){
            return Size.MEDIUM;
        }else{
            return Size.LARGE;
        }
    }

    private void setNyCrust(String flavor){
        if(flavor.equalsIgnoreCase("Deluxe")){
            nyCrust.setText("Brooklyn");
        }else if (flavor.equalsIgnoreCase("BBQ Chicken")){
            nyCrust.setText("Thin");
        }else if (flavor.equalsIgnoreCase("Meatzza")){
            nyCrust.setText("Hand Tossed");
        }else { // Build your Own
            nyCrust.setText("Hand Tossed");
        }
    }

    private void setNySelectedToppings(String flavor) {
        if(flavor.equalsIgnoreCase("Build your own")){
            nySelectedToppings.getItems().clear();
            nyAddButton.setDisable(false);
            nyRemoveButton.setDisable(false);
            return;
        }
        nyAddButton.setDisable(true);
        nyRemoveButton.setDisable(true);
        if(flavor.equalsIgnoreCase("Deluxe")){
            nySelectedToppings.setItems(FXCollections.observableArrayList("Sausage","pepperoni","green pepper","onion","mushroom"));
        }else if (flavor.equalsIgnoreCase("BBQ Chicken")){
            nySelectedToppings.setItems(FXCollections.observableArrayList("BBQ chicken", "green pepper", "provolone", "cheddar"));
        }else{
            nySelectedToppings.setItems(FXCollections.observableArrayList("Sausage", "pepperoni", "Beef", "Ham"));
        }
    }


    @FXML
    public void nySmallSelected(){
        pizza.setSize(Size.SMALL);
        updatePrice();
    }

    @FXML
    public void nyMediumSelected(){
        pizza.setSize(Size.MEDIUM);
        updatePrice();
    }


    @FXML
    public void nyLargeSelected(){
        pizza.setSize(Size.LARGE);
        updatePrice();
    }


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

            Image chicago = new Image("file:src/images/"+imageName);
            NyPizzaImage.setImage(chicago);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nyAddButton.setDisable(true);
        nyRemoveButton.setDisable(true);


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

        nyAddToOrder.setDisable(true);
    }

    @FXML
    public void nyFlavorPicked(ActionEvent actionEvent){
        String flavorPicked = nyFlavors.getValue();
        setNyPizzaImage(flavorPicked);


        if(flavorPicked.equalsIgnoreCase("deluxe")){
            pizza = pizzaFactory.createDeluxe();
        }else if(flavorPicked.equalsIgnoreCase("meatzza")){
            pizza = pizzaFactory.createMeatzza();
        }else if(flavorPicked.equalsIgnoreCase("BBQ Chicken")){
            pizza = pizzaFactory.createBBQChicken();
        }else {
            pizza = pizzaFactory.createBuildYourOwn();
        }

        pizza.setSize(getSize());
        updatePrice();


        // crust is displayed
        setNyCrust(flavorPicked);

        // selected toppings showed on UI
        setNySelectedToppings(flavorPicked);


    }

    @FXML
    public void nyAddTopping(ActionEvent actionEvent){
        String selectedTopping = availableNyToppings.getSelectionModel().getSelectedItem();
        if(selectedTopping==null){
            return;
        }

        for(String item : nySelectedToppings.getItems()){
            boolean found = false;

            if(item.equalsIgnoreCase(selectedTopping)){
                return;
            }

        }
        nySelectedToppings.getItems().add(selectedTopping);

    }

    @FXML
    public void removeNyTopping(ActionEvent actionEvent){
        String selectedTopping = nySelectedToppings.getSelectionModel().getSelectedItem();
        if(selectedTopping==null){return;}
        nySelectedToppings.getItems().remove(selectedTopping);
    }

    @FXML
    public void nyAddToCurrentOrder(){
         pizza.setToppings(new ArrayList<Topping>());

         for(String top: nySelectedToppings.getItems()){
             pizza.getToppings().add(new Topping(top));
         }


         CurrentOrderController.currentOrder.add(pizza);

    }




}
