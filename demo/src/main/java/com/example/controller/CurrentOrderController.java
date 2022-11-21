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

        double salesTax =  (.06625) *calculateSubTotal();

        double scale = Math.pow(10, 2);
        return Math.round(salesTax * scale) / scale;
    }

    public double calculateOrderTotal(){

        double orderTotal = calculateSubTotal()+calculateSalesTax();
        double scale = Math.pow(10, 2);
        return Math.round(orderTotal * scale) / scale;
    }



    private void updateOrderTotalTextField(){
        if(currentOrder.getItems()!=null && currentOrder.getItems().size()>0){
            orderTotalTextField.setText(Double.toString(calculateOrderTotal()));
        }else{
            orderTotalTextField.setText("");
        }
    }

    private void updateSalesTaxTextField(){

        if(currentOrder.getItems()!=null && currentOrder.getItems().size()>0){
            salesTaxTextField.setText(Double.toString(calculateSalesTax()));
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
            subTotalTextField.setText(Double.toString(calculateSubTotal()));
        }else{
            subTotalTextField.setText("");
        }
    }


    @FXML
    void addOrderToStoreOrders(ActionEvent event) {
       // add currentOrder to StoreOrder db
        //make new order to next order number is incremented by 1
        currentOrder = new Order();
    }

    @FXML
    void clearOrder(ActionEvent event) {


        // list view is updated
        orderListView.getItems().clear();

        currentOrder.clearOrder();
        updateSalesTaxTextField();
        updateSubTotalTextField();
        updateOrderTotalTextField();
        updateOrderNumberTextField();
    }



    @FXML
    void removePizzaFromOrder(ActionEvent event) {

        int pizzaToBeRemoved  = orderListView.getSelectionModel().getSelectedIndex();
        currentOrder.getItems().remove(pizzaToBeRemoved);
        // list view is updated
        orderListView.getItems().remove(pizzaToBeRemoved);

        // other fields are updated
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








