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
import java.util.ResourceBundle;

public class ChicagoStyleController implements Initializable {


    // constants

    private final int SMALL = 1;
    private final int MEDIUM = 2;
    private final int LARGE = 3;


    @FXML
    private Button addButton;

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


    // need this to make Order obj global
    private CurrentOrderController currentOrderController;




    /** *
     *
     * Manipulates image
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
        Image chicago = new Image("file:src/images/"+imageName);
        chicagoPizzaImage.setImage(chicago);
    }




    @FXML
    public void smallSelected(){
        pizza.setSize(Size.SMALL);
        updatePrice();
    }

    @FXML
    public void mediumSelected(){
        pizza.setSize(Size.MEDIUM);
        updatePrice();
    }


    @FXML
    public void largeSelected(){
        pizza.setSize(Size.LARGE);
        updatePrice();
    }

    private void updatePrice() {
        chicagoPrice.setText(Double.toString(pizza.price()));
    }



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
     *
     * Set up list view, image, and  combo box
     *
     * */
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
    }




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




    public void addToCurrentOrder(ActionEvent actionEvent){
        currentOrderController.getCurrentOrder().add(pizza);
        System.out.println(pizza + " ADDED TO CURRENT ORDER");
    }

     /**
      * when flavor is picked, image is updated
      * */
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

    }




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
     *
     * when ">>" is clicked topping is added to selected toppings
     * */
    @FXML
    public void addTopping(ActionEvent actionEvent){

        String selectedTopping = availableChicagoToppings.getSelectionModel().getSelectedItem();
        if(selectedTopping==null){
            return;

        }
        for(String item : selectedToppings.getItems()){
            boolean found = false;

            if(item.equalsIgnoreCase(selectedTopping)){
                return;
            }
        }
         selectedToppings.getItems().add(selectedTopping);

    }


    /**
     *
     * when "<<" is selected topping is removed from selected toppings
     * */

    @FXML
    public void removeTopping(ActionEvent actionEvent){
        String selectedTopping = selectedToppings.getSelectionModel().getSelectedItem();
        if(selectedTopping==null){return;}
        selectedToppings.getItems().remove(selectedTopping);
    }
}
