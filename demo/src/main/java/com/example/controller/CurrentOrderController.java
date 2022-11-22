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
    private  ListView<String> orderListView;


    @FXML
    private TextField orderNumberTextField;

    @FXML
    private TextField orderTotalTextField;

    @FXML
    private TextField salesTaxTextField;

    @FXML
    private TextField subTotalTextField;


    private double calculateSubTotal(){
        double totalPrice = 0;

        if(currentOrder.getItems()==null){
            return totalPrice;
        }

        for(Pizza pizza : currentOrder.getItems()){
            totalPrice+=(pizza.price());
        }

        double scale = Math.pow(10, 2);
        return Math.round(totalPrice * scale) / scale;
    }


    public double calculateSalesTax(){ // based on 6.625% sales tax
        return (.06625) *calculateSubTotal();
    }

    public double calculateOrderTotal(){
        double orderTotal = calculateSubTotal()+calculateSalesTax();
        return  orderTotal;
    }



    private void updateOrderTotalTextField(){
        if(currentOrder.getItems()!=null && currentOrder.getItems().size()>0){
            orderTotalTextField.setText(String.format("%.2f", calculateOrderTotal()));
        }else{
            orderTotalTextField.setText("");
        }
    }

    private void updateSalesTaxTextField(){
        if(currentOrder.getItems()!=null && currentOrder.getItems().size()>0){
            salesTaxTextField.setText(String.format("%.2f", calculateSalesTax()));
        }else{
            salesTaxTextField.setText("");
        }
    }


    private void updateOrderNumberTextField(){
        if(currentOrder.getItems()!=null && currentOrder.getItems().size()>0){
            orderNumberTextField.setText(Integer.toString(currentOrder.getOrderNumber()));
        }else{
            orderNumberTextField.setText("");
        }
    }




    private void updateListView(){
        if(currentOrder.getItems()!=null && currentOrder.getItems().size()>0){
            for(Pizza piz: currentOrder.getItems() ){
                orderListView.getItems().add(piz.toString());
            }
        }else{
            return;
        }
    }


    private void updateSubTotalTextField(){
        if(currentOrder.getItems()!=null && currentOrder.getItems().size()>0){
            subTotalTextField.setText(String.format("%.2f", calculateSubTotal()));
        }else{
            subTotalTextField.setText("");
        }
    }


    @FXML
    void addOrderToStoreOrders(ActionEvent event) {
        if(orderListView.getItems().size()==0|| currentOrder.getItems()==null || currentOrder.getItems().size()==0){
            return;
        }
        currentOrder.setTotalPrice(Double.parseDouble(orderTotalTextField.getText()));
        StoreOrdersController.storeOrder.add(currentOrder);
        currentOrder = new Order();
    }

    @FXML
    void clearOrder(ActionEvent event) {
        orderListView.getItems().clear();
        currentOrder.clearOrder();
        updateSalesTaxTextField();
        updateSubTotalTextField();
        updateOrderTotalTextField();
        updateOrderNumberTextField();
    }



    @FXML
    void removePizzaFromOrder(ActionEvent event) {
        if(orderListView.getSelectionModel().getSelectedIndex()==-1){
            return;
        }
        int pizzaToBeRemoved  = orderListView.getSelectionModel().getSelectedIndex();
        currentOrder.getItems().remove(pizzaToBeRemoved);
        orderListView.getItems().remove(pizzaToBeRemoved);
        updateSalesTaxTextField();
        updateSubTotalTextField();
        updateOrderTotalTextField();
        updateOrderNumberTextField();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateListView();
        updateSubTotalTextField();
        updateSalesTaxTextField();
        updateOrderTotalTextField();
        updateOrderNumberTextField();
    }


}








