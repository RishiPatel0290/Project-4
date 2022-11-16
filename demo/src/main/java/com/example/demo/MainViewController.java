package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    @FXML
    private ImageView nyStyle;

    @FXML
    private ImageView chicagoStyle;

    @FXML
    private ImageView currentOrders;

    @FXML
    private ImageView storeOrders;



    /**
     *
     * purpose: to set up  images
     *
     * */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{

            Image chicago= new Image("file:src/images/chicago.png");
            chicagoStyle.setImage(chicago);
        }catch (Exception e){
            System.out.println(e.toString());
        }

        try{

            Image ny = new Image("file:src/images/nyc.png");
            nyStyle.setImage(ny);
        }catch (Exception e){
            System.out.println(e.toString());
        }

        try{

            Image shoppingCart= new Image("file:src/images/shoppingcart.png");
            currentOrders.setImage(shoppingCart);
        }catch (Exception e){
            System.out.println(e.toString());
        }

        try{

            Image store= new Image("file:src/images/store.png");
            storeOrders.setImage(store);
        }catch (Exception e){
            System.out.println(e.toString());
        }

    }





}