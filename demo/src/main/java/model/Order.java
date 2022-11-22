package model;

import java.util.ArrayList;

public class Order implements Customizable{

    private static final int STARTING_NUMBER = 1;
    static int orderTracker = STARTING_NUMBER;
    private int orderNumber;

    private double totalPrice;

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    private ArrayList<Pizza> orderedItems;

    public Order(){
        this.orderedItems = new ArrayList<Pizza>();
        this.orderNumber = orderTracker;
        orderTracker++;
    }

    public void clearOrder(){
        this.orderedItems = new ArrayList<Pizza>();
    }

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
