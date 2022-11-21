package com.example.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Order;
import model.Pizza;

import java.net.URL;
import java.util.ResourceBundle;

public class CurrentOrderController implements Initializable {

    static Order currentOrder = new Order();


    @FXML
    private ListView<String> orderListView;

    @FXML
    private TextField orderNumberTextField;

    @FXML
    private TextField orderTotalTextField;

    @FXML
    private TextField salesTaxTextField;

    @FXML
    private TextField subTotalTextField;

    @FXML
    void addOrderToStoreOrders(ActionEvent event) {
       // add currentOrder to StoreOrder db
        //reset current order
        currentOrder = new Order();
    }

    @FXML
    void clearOrder(ActionEvent event) {
      // reset current order
       currentOrder.clearOrder();

    }



    @FXML
    void removePizzaFromOrder(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        orderNumberTextField.setText(  Integer.toString(currentOrder.getOrderNumber())  );

        for(Pizza piz: currentOrder.getItems() ){
            orderListView.getItems().add(piz.toString());
        }


    }


}








