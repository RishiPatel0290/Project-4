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

/**
 * Class to handle the CurrentOrder-view.fxml view and displays the order details with pricing
 * @author Rishi Patel, Devam Patel
 */
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

    /**
     * Calculates subtotal of the pizza depending on size, flavor, and toppings
     * @return double subtotal price of the pizza
     */
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


    /**
     * Calculates the sale's tax for the current order
     * @return double amount of money gone for sales tax which is 6.625%
     */
    public double calculateSalesTax(){ // based on 6.625% sales tax
        return (.06625) *calculateSubTotal();
    }

    /**
     * Calculates the final total price of the total order with tax
     * @return double total price of the order
     */
    public double calculateOrderTotal(){
        double orderTotal = calculateSubTotal()+calculateSalesTax();
        return  orderTotal;
    }


    /**
     * Method to update the  view for the order total field
     */
    private void updateOrderTotalTextField(){
        if(currentOrder.getItems()!=null && currentOrder.getItems().size()>0){
            orderTotalTextField.setText(String.format("%.2f", calculateOrderTotal()));
        }else{
            orderTotalTextField.setText("");
        }
    }

    /**
     * Method to update the  view for the sales tax field
     */
    private void updateSalesTaxTextField(){
        if(currentOrder.getItems()!=null && currentOrder.getItems().size()>0){
            salesTaxTextField.setText(String.format("%.2f", calculateSalesTax()));
        }else{
            salesTaxTextField.setText("");
        }
    }

    /**
     * Method to update the  view for the order number field
     */
    private void updateOrderNumberTextField(){
        if(currentOrder.getItems()!=null && currentOrder.getItems().size()>0){
            orderNumberTextField.setText(Integer.toString(currentOrder.getOrderNumber()));
        }else{
            orderNumberTextField.setText("");
        }
    }


    /**
     * Method to update the list view of the pizzas and their details in current order
     */
    private void updateListView(){
        if(currentOrder.getItems()!=null && currentOrder.getItems().size()>0){
            for(Pizza piz: currentOrder.getItems() ){
                orderListView.getItems().add(piz.toString());
            }
        }else{
            return;
        }
    }

    /**
     * Method to update the view for the subtotal field
     */
    private void updateSubTotalTextField(){
        if(currentOrder.getItems()!=null && currentOrder.getItems().size()>0){
            subTotalTextField.setText(String.format("%.2f", calculateSubTotal()));
        }else{
            subTotalTextField.setText("");
        }
    }

    /**
     * Method that handles the "Place order" button and adds the order to store order
     * @param event default parameter for action listener
     */
    @FXML
    void addOrderToStoreOrders(ActionEvent event) {
        if(orderListView.getItems().size()==0|| currentOrder.getItems()==null || currentOrder.getItems().size()==0){
            return;
        }
        currentOrder.setTotalPrice(Double.parseDouble(orderTotalTextField.getText()));
        StoreOrdersController.storeOrder.add(currentOrder);
        currentOrder = new Order();
    }

    /**
     * Method that handles the "Clear order" button and clears the order and the fields in the view
     * @param event default parameter for action listener
     */
    @FXML
    void clearOrder(ActionEvent event) {
        orderListView.getItems().clear();
        currentOrder.clearOrder();
        updateSalesTaxTextField();
        updateSubTotalTextField();
        updateOrderTotalTextField();
        updateOrderNumberTextField();
    }


    /**
     * Method that handles "Remove pizza" button and removes the pizza from the current order
     * @param event default parameter for action listener
     */
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

    /**
     * Initializes the beginning view of the fxml file for the relevant fields
     * @param url default parameter for the method
     * @param resourceBundle default parameter for the method
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateListView();
        updateSubTotalTextField();
        updateSalesTaxTextField();
        updateOrderTotalTextField();
        updateOrderNumberTextField();
    }


}








