package com.example.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * This class controls the NyStyle-view.fxml and manages the pizza order for NY store
 * @author Devam Patel, Rishi Patel
 */
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


    /**
     * Updates the price field in the fxml file and rounds the text to 2 decimal places
     */
    private void updatePrice() {
        nyPrice.setText(String.format("%.2f", pizza.price()));
    }

    /**
     * Returns the size of current pizza
     * @return Size instance that the pizza represents.
     */
    private Size getSize(){
        if(nySmall.isSelected()){
            return Size.SMALL;
        }else if (nyMedium.isSelected()){
            return Size.MEDIUM;
        }else{
            return Size.LARGE;
        }
    }

    /**
     * Sets the crust field on the fxml view to its appropriate value
     * @param flavor String representation of the flavor created
     */
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

    /**
     * Adds value and displays it under the "Selected Toppings" list view in the fxml file, based on the flavor selected
     * @param flavor String representation of the flavor
     */
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

    /**
     * sets the size property in Pizza object to small and calls update price
     */
    @FXML
    public void nySmallSelected(){
        pizza.setSize(Size.SMALL);
        updatePrice();
    }

    /**
     * sets the size property in Pizza class to medium and calls update price
     */
    @FXML
    public void nyMediumSelected(){
        pizza.setSize(Size.MEDIUM);
        updatePrice();
    }

    /**
     * sets the size property in Pizza object to large and calls update price
     */
    @FXML
    public void nyLargeSelected(){
        pizza.setSize(Size.LARGE);
        updatePrice();
    }


    /**
     * Sets the image of the pizza depending on the flavor picked by the user
     * @param flavor String representation of the flavor user queried.
     */
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

    /**
     * Initializes the beginning view of the fxml file for the relevant fields
     * @param url default parameter for the method
     * @param resourceBundle default parameter for the method
     */
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

    /**
     * Method that provides dynamic changes to the view upon the click of a different flavor by the user
     * @param actionEvent default parameter for action listener
     */
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

        nyAddToOrder.setDisable(false);


    }

    /**
     * Method that listens to for ">>" button and adds the topping to the pizza
     * @param actionEvent default parameter for action listener
     * @throws IOException exception to handle any errors for loading fxml files.
     */
    @FXML
    public void nyAddTopping(ActionEvent actionEvent) throws IOException {
        String selectedTopping = availableNyToppings.getSelectionModel().getSelectedItem();
        if(selectedTopping==null){return;}

        for(String item : nySelectedToppings.getItems()){
            boolean found = false;
            if(item.equalsIgnoreCase(selectedTopping)){ return; }

        }

        if(nyFlavors.getValue().equalsIgnoreCase("Build your own") && nySelectedToppings.getItems().size()>=7){
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ToppingAlert-view.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Topping Alert");
            stage.setScene(scene);
            stage.show();

            return;
        }

        nySelectedToppings.getItems().add(selectedTopping);

        if(nyFlavors.getValue().equalsIgnoreCase("Build Your Own")){
            if(pizza.getToppings()==null){
                pizza.setToppings(new ArrayList<Topping>());
            }
            pizza.getToppings().add(new Topping(selectedTopping));
        }

        updatePrice();

    }

    /**
     * Method to handle "<<" button and remove topping from the selected topics list view
     * @param actionEvent default parameter for action listener
     */
    @FXML
    public void removeNyTopping(ActionEvent actionEvent){
        String selectedTopping = nySelectedToppings.getSelectionModel().getSelectedItem();
        if(selectedTopping==null){return;}
        int indexToBeRemoved = nySelectedToppings.getSelectionModel().getSelectedIndex();
        nySelectedToppings.getItems().remove(selectedTopping);
        pizza.getToppings().remove(indexToBeRemoved);
        updatePrice();
    }

    /**
     * Adds the current pizza on the view to the ongoing order
     * @param actionEvent default paramter for action listener
     */
    @FXML
    public void nyAddToCurrentOrder(ActionEvent actionEvent){

        if(pizza.getToppings()==null){
            pizza.setToppings(new ArrayList<Topping>());
        }

        if(!nyFlavors.getValue().equalsIgnoreCase("Build your own")) {
            for (String top : nySelectedToppings.getItems()) {
                pizza.getToppings().add(new Topping(top));
            }
        }

         pizza.setCrust(new Crust(nyCrust.getText()));
         CurrentOrderController.currentOrder.add(pizza);
         nyFlavorPicked(null);

    }




}
