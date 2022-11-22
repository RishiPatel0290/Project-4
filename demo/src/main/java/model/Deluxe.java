package model;

import java.util.ArrayList;
/**
 * This class serves as the model of a deluxe pizza and handles appropriate properties of the pizza.
 * @author Devam Patel, Rishi Patel
 */
public class Deluxe extends Pizza{




    final static double SMALL_PRICE=14.99;
    final static double MEDIUM_PRICE=16.99;
    final static double LARGE_PRICE=18.99;

    /**
     * overrides the pizza class method for add
     * @param obj Object to add to Deluxe
     * @return false, as no use in this case.
     */

    @Override
    public boolean add(Object obj) {
        return false;
    }

    /**
     * overrides the pizza class method for remove
     * @param obj Object to remove in Deluxe
     * @return false, as no use in this case.
     */
    @Override
    public boolean remove(Object obj) {
        return false;
    }

    /**
     * computes the price of the pizza based on size
     * @return double price of a deluxe pizza based on its size
     */
    @Override
    public double price() {
        if(getSize()==Size.SMALL){
            return SMALL_PRICE;
        }else if(getSize()==Size.MEDIUM){
            return MEDIUM_PRICE;
        }else{
            return LARGE_PRICE;
        }

    }

    /**
     * String representation of deluxe pizza
     * @return String representation of deluxe pizza with its crust, toppings, size, and price details
     */
    @Override
    public String toString() {
        return "Deluxe ("+getCrust()+") "+getToppings().toString()+", "+getSize().toString().toLowerCase()+", "+price();
    }
}
