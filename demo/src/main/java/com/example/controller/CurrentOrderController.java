package com.example.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Order;

public class CurrentOrderController {

    private Order currentOrder;

    @FXML
    private ListView<?> orderListView;

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

    }

    @FXML
    void clearOrder(ActionEvent event) {

    }

    @FXML
    void removePizzaFromOrder(ActionEvent event) {

    }

}







//package com.example.controller;
//
//
//import model.Order;
//
//public class CurrentOrderController {
//    private Order currentOrder;
//
//    public Order getCurrentOrder() {
//        return currentOrder;
//    }
//
//    public void setCurrentOrder(Order currentOrder) {
//        this.currentOrder = currentOrder;
//    }
//
//
//
//}


