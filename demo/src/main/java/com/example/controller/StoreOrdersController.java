package com.example.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Order;
import model.Pizza;
import model.StoreOrder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * This class controls the StoreOrders-view.fxml and manages the pizza orders
 * @author Devam Patel, Rishi Patel
 */
public class StoreOrdersController implements Initializable {

    static StoreOrder storeOrder = new StoreOrder();

    @FXML
    private ListView<String> orderListVIew;

    @FXML
    private ComboBox<Integer> orderNumberCombo;

    @FXML
    private TextField orderTotal;


    /**
     * Private method that updates the combo box depending on orders added
     */
    private void updateOrdersView(){
        ArrayList<Integer> updatedListOfOrderNumbers = new ArrayList<>();
        for(Order order: storeOrder.getStoreOrders()){
            updatedListOfOrderNumbers.add(order.getOrderNumber());
        }
        orderNumberCombo.setItems(FXCollections.observableArrayList(updatedListOfOrderNumbers));
    }

    /**
     * Cancels the selected order from the list of orders in store orders
     * @param event default parameter for action listener
     */
    @FXML
    void cancelOrder(ActionEvent event) {
        Integer orderSelected = orderNumberCombo.getValue();
        if(orderSelected!=null){
            Order toBeRemoved = null;
            for(Order order: storeOrder.getStoreOrders()){
                if(order!=null){
                    if(order.getOrderNumber()==orderSelected){
                        toBeRemoved = order;
                    }
                }
            }
            storeOrder.remove(toBeRemoved);
            updateOrdersView();
            orderTotal.setText("");
        }
    }

    /**
     * Method that handles the "export orders" button and writes all the order to a file in java/data/orders.txt
     * @throws IOException exception to handle errors when writing to orders.txt file.
     */
    @FXML
    public void exportOrders () throws IOException {
        File file = new File("src/main/java/data/orders.txt");
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter (fileWriter);
        for (Order order : storeOrder.getStoreOrders()) {
            printWriter.println("Order #" + order.getOrderNumber());
            for (Pizza pizza : order.getItems()) {
                printWriter.println(pizza.toString());
            }
            printWriter.println("Order Total: $" + order.getTotalPrice());
            printWriter.println();
            printWriter.println();
        }
        printWriter.close();
        fileWriter.close();
    }

    /**
     * return the Order instance with the given number
     * @param number int number of the order that represents the Order instance
     * @return the Order instance with the same order number property
     */
    public Order getOrderByNumber(int number){
        for(Order order : storeOrder.getStoreOrders()){
            if(order.getOrderNumber()==number){
                return order;
            }
        }
        return null;
    }

    /**
     * Adds value to the listview and the total order field of the view
     * @param actionEvent default parameter for action listener
     */
    public void updateOrderViewListAndTotal(ActionEvent actionEvent){
        orderListVIew.getItems().clear();
        if(orderNumberCombo.getValue()==null){
            return;
        }
        int orderNumber = orderNumberCombo.getValue();
        Order order = getOrderByNumber(orderNumber);
        for(Pizza pizza:order.getItems()){
            orderListVIew.getItems().add(pizza.toString());
        }
        orderTotal.setText(String.format("%.2f", order.getTotalPrice()));
    }


    /**
     * Initializes the beginning view of the fxml file for the relevant fields
     * @param url default parameter for the method
     * @param resourceBundle default parameter for the method
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Integer>orderNumbers = new ArrayList<>();
        for(Order order : storeOrder.getStoreOrders()){
            orderNumbers.add(order.getOrderNumber());
        }
        orderNumberCombo.setItems(FXCollections.observableArrayList(orderNumbers));
    }
}
