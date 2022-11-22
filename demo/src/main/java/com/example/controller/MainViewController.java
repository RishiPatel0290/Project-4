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

/**
 * Class that handles the Main-view.fxml file and displays content for the main page of the application
 * @author Devam Patel, Rishi Patel
 */
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
     * Initializes the beginning view of the fxml file for the relevant fields
     * @param url default parameter for the method
     * @param resourceBundle default parameter for the method
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


            Image chicago= new Image("file:src/images/chicago.png");
            chicagoStyle.setImage(chicago);


            Image ny = new Image("file:src/images/nyc.png");
            nyStyle.setImage(ny);


            Image shoppingCart= new Image("file:src/images/shoppingcart.png");
            currentOrders.setImage(shoppingCart);

            Image store= new Image("file:src/images/store.png");
            storeOrders.setImage(store);


    }

    /**
     * Method opens the page for NY store of pizza upon the query of user
     * @param event default parameter for action listener
     * @throws IOException exception to handle loading fxml files
     */
    @FXML
    void openNYWindow(ActionEvent event) throws IOException {

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("NYStyle-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("NY Style");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Method opens the page for Chicago store of pizza upon the query of user
     * @param event default parameter for action listener
     * @throws IOException exception to handle loading fxml files
     */
    @FXML
    void openChicagoWindow(ActionEvent event) throws IOException{

          Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ChicagoStyle-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Chicago Style");
            stage.setScene(scene);
            stage.show();

    }

    /**
     * Method opens the page for the current order of pizzas upon the query of user
     * @param event default parameter for action listener
     * @throws IOException exception to handle loading fxml files
     */
    @FXML
    void openCurrentOrderWindow(ActionEvent event) throws IOException {

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CurrentOrder-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Current Order Style");
        stage.setScene(scene);
        stage.show();


    }


    /**
     * Method opens the page for the store orders upon the query of user
     * @param event default parameter for action listener
     * @throws IOException exception to handle loading fxml files
     */
    @FXML
    void openStoreOrdersWindow(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("StoreOrders-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Store Orders");
        stage.setScene(scene);
        stage.show();
    }





}