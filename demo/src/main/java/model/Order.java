package model;

import java.util.ArrayList;

/**
 * Class that servers as a model for an pizza order and handles all its properties
 * @author Devam Patel, Rishi Patel
 */
public class Order implements Customizable{

    private static final int STARTING_NUMBER = 1;
    static int orderTracker = STARTING_NUMBER;
    private int orderNumber;

    private double totalPrice;

    /**
     * method to return the total price of the order
     * @return double total price of the Order instance
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Method to set the total price of the order
     * @param totalPrice double total price to set in the Order instance
     */
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    private ArrayList<Pizza> orderedItems;

    /**
     * Constructor of Order instance and instantiates the pizza list and order number
     */
    public Order(){
        this.orderedItems = new ArrayList<Pizza>();
        this.orderNumber = orderTracker;
        orderTracker++;
    }

    /**
     * Clears the current order of pizzas in the instance
     */
    public void clearOrder(){
        this.orderedItems = new ArrayList<Pizza>();
    }

    /**
     * returns the order number of this instance
     * @return the order number of this instance
     */
    public int getOrderNumber() {
        return orderNumber;
    }






    @Override
    public boolean add(Object obj) {
        Pizza toBeAdded = (Pizza) obj;
        return orderedItems.add(toBeAdded);

    }


    // might have issue while finding correct pizza
    @Override
    public boolean remove(Object obj) {
        Pizza toBeRemoved = (Pizza) obj;
        return  orderedItems.remove(toBeRemoved);
    }

    public ArrayList<Pizza> getItems() {
        return this.orderedItems;
    }


    @Override
    public String toString() {
        String rslt = "";



        return rslt;
    }
}
