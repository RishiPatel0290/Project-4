package com.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    @FXML
    private ImageView nyStyle = new ImageView();

    @FXML
    private ImageView chicagoStyle = new ImageView();

    @FXML
    private ImageView currentOrders = new ImageView();

    @FXML
    private ImageView storeOrders = new ImageView();



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


    @FXML
    void openChicagoWindow(ActionEvent event) throws IOException{
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ChicagoStyle-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void openCurrentOrdersWindow(ActionEvent event) throws IOException {

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CurrentOrder-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void openNYWindow(ActionEvent event) throws IOException {

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("NYStyle-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void openStoreOrdersWindow(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("StoreOrders-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }





}