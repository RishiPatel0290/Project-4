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
 * This class controls the ChicagoStyle-view.fxml and manages the pizza order for Chicago store
 * @author Devam Patel, Rishi Patel
 */
public class ChicagoStyleController implements Initializable {

    @FXML
    private Button addButton;

    @FXML
    private Button addToOrder;

    @FXML
    private Button removeButton;
    @FXML
    private TextField chicagoPrice;


    @FXML
    private TextField chicagoCrust;


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


    private PizzaFactory pizzaFactory = new ChicagoPizza();




    // this will be added to list of order
    private Pizza pizza;


    /**
     * Sets the image of the pizza depending on the flavor picked by the user
     * @param flavor String representation of the flavor user queried.
     */
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
        Image chicago = new Image("file:src/images/"+imageName);
        chicagoPizzaImage.setImage(chicago);
    }


    /**
     * sets the size property in Pizza object to small and calls update price
     */
    @FXML
    public void smallSelected(){
        pizza.setSize(Size.SMALL);
        updatePrice();
    }

    /**
     * sets the size property in Pizza object to medium and calls update price
     */
    @FXML
    public void mediumSelected(){
        pizza.setSize(Size.MEDIUM);
        updatePrice();
    }

    /**
     * sets the size property in Pizza object to large and calls update price
     */
    @FXML
    public void largeSelected(){
        pizza.setSize(Size.LARGE);
        updatePrice();
    }

    /**
     * Updates the price field in the fxml file and rounds the text to 2 decimal places
     */
    private void updatePrice() {
        chicagoPrice.setText(String.format("%.2f", pizza.price()));
    }


    /**
     * Returns the size of current pizza
     * @return Size instance that the pizza represents.
     */
    private Size getSize(){
        if(small.isSelected()){
            return Size.SMALL;
        }else if (medium.isSelected()){
            return Size.MEDIUM;
        }else{
            return Size.LARGE;
        }
    }


    /**
     * Initializes the beginning view of the fxml file for the relevant fields
     * @param url default parameter for the method
     * @param resourceBundle default parameter for the method
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // add & remove button disabled
        addButton.setDisable(true);
        removeButton.setDisable(true);
        // populate flavors
        chicagoFlavors.setItems(FXCollections.observableArrayList("Deluxe","BBQ Chicken","Meatzza","Build your own"));
        //populate available toppings
        availableChicagoToppings.getItems().addAll("Sausage", "pepperoni", "green pepper", "onion", "mushroom", "BBQ chicken", "provolone", "cheddar", "beef", "ham", "Pineapple", "Spinach", "Black olives");
        // set default image
        setChicagoPizzaImage("");
        // add to order must be disabled
        addToOrder.setDisable(true);
    }


    /**
     * Sets the crust field on the fxml view to its appropriate value
     * @param flavor String representation of the flavor created
     */
    private void setChicagoCrust(String flavor){
        if(flavor.equalsIgnoreCase("Deluxe")){
            chicagoCrust.setText("Deep Dish");
        }else if (flavor.equalsIgnoreCase("BBQ Chicken")){
            chicagoCrust.setText("Pan");
        }else if (flavor.equalsIgnoreCase("Meatzza")){
            chicagoCrust.setText("Stuffed");
        }else { // Build your Own
            chicagoCrust.setText("Pan");
        }
    }


    /**
     * Adds the current pizza on the view to the ongoing order
     * @param actionEvent default paramter for action listener
     */
    public void addToCurrentOrder(ActionEvent actionEvent){
        if(pizza.getToppings()==null){
            pizza.setToppings(new ArrayList<Topping>());
        }
        if(!chicagoFlavors.getValue().equalsIgnoreCase("Build Your Own")){
            for(String top: selectedToppings.getItems()){
                pizza.getToppings().add(new Topping(top));
            }
        }
        pizza.setCrust(new Crust(chicagoCrust.getText()));
        CurrentOrderController.currentOrder.add(pizza);
        // have to make new pizza based on selected flavor
        chicagoFlavorPicked(null);
    }

    /**
     * Method that provides dynamic changes to the view upon the click of a different flavor by the user
     * @param actionEvent default parameter for action listener
     */
    @FXML
    public void chicagoFlavorPicked(ActionEvent actionEvent){
        String flavorPicked = chicagoFlavors.getValue();
        // set image based on flavor selected
        setChicagoPizzaImage(flavorPicked);
        if(flavorPicked.equalsIgnoreCase("deluxe")){
            pizza = pizzaFactory.createDeluxe();
        }else if(flavorPicked.equalsIgnoreCase("meatzza")){
            pizza = pizzaFactory.createMeatzza();
        }else if(flavorPicked.equalsIgnoreCase("BBQ Chicken")){
            pizza = pizzaFactory.createBBQChicken();
        }else {
            pizza = pizzaFactory.createBuildYourOwn();
        }
        // update default size which is small
        pizza.setSize(getSize());
        updatePrice();
        // crust is displayed
        setChicagoCrust(flavorPicked);
        // selected toppings showed on UI
        setSelectedToppings(flavorPicked);
        // have to enable add to order button
        addToOrder.setDisable(false);
    }


    /**
     * Adds value and displays it under the "Selected Toppings" list view in the fxml file, based on the flavor selected
     * @param flavor String representation of the flavor
     */
    private void setSelectedToppings(String flavor) {
        if(flavor.equalsIgnoreCase("Build your own")){
            selectedToppings.getItems().clear();
            addButton.setDisable(false);
            removeButton.setDisable(false);
            return;
        }
        addButton.setDisable(true);
        removeButton.setDisable(true);
        if(flavor.equalsIgnoreCase("Deluxe")){
            selectedToppings.setItems(FXCollections.observableArrayList("Sausage","pepperoni","green pepper","onion","mushroom"));
        }else if (flavor.equalsIgnoreCase("BBQ Chicken")){
            selectedToppings.setItems(FXCollections.observableArrayList("BBQ chicken", "green pepper", "provolone", "cheddar"));
        }else{
            selectedToppings.setItems(FXCollections.observableArrayList("Sausage", "pepperoni", "Beef", "Ham"));
        }
    }


    /**
     * Method that listens to for ">>" button and adds the topping to the pizza
     * @param actionEvent default parameter for action listener
     * @throws IOException exception to handle any errors for loading fxml files.
     */
    @FXML
    public void addTopping(ActionEvent actionEvent) throws IOException {
        String selectedTopping = availableChicagoToppings.getSelectionModel().getSelectedItem();
        if(selectedTopping==null){
            return;
        }
        // checks if same topping is already selected
        for(String item : selectedToppings.getItems()){
            boolean found = false;
            if(item.equalsIgnoreCase(selectedTopping)){
                return;
            }
        }
        // make alert if we have more than 7 toppings
        if(chicagoFlavors.getValue().equalsIgnoreCase("Build your own") && selectedToppings.getItems().size()>=7){
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ToppingAlert-view.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Topping Alert");
            stage.setScene(scene);
            stage.show();
            return;
        }
        selectedToppings.getItems().add(selectedTopping);
        if(chicagoFlavors.getValue().equalsIgnoreCase("Build your own")){
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
    public void removeTopping(ActionEvent actionEvent){
        String selectedTopping = selectedToppings.getSelectionModel().getSelectedItem();
        if(selectedTopping==null){return;}
        int indexToBeRemoved = selectedToppings.getSelectionModel().getSelectedIndex();
        selectedToppings.getItems().remove(selectedTopping);
        pizza.getToppings().remove(indexToBeRemoved);
        updatePrice();
    }
}
