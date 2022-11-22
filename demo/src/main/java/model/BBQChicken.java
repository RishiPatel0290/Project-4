package model;

/**
 * This class serves as the model of a bbq chicken pizza and handles appropriate properties of the pizza.
 * @author Devam Patel, Rishi Patel
 */

public class BBQChicken extends Pizza{
    final static double SMALL_PRICE= 13.99;
    final static double MEDIUM_PRICE= 15.99;
    final static double LARGE_PRICE= 17.99;


    /**
     * overrides the pizza class method for add
     * @param obj Object to add to BBQChicken
     * @return false, as no use in this case.
     */
    @Override
    public boolean add(Object obj) {
        return false;
    }
    /**
     * overrides the pizza class method for remove
     * @param obj Object to remove in BBQChicken
     * @return false, as no use in this case.
     */
    @Override
    public boolean remove(Object obj) {
        return false;
    }

    /**
     * computes the price of the pizza based on size
     * @return double price of a bbq chicken pizza based on its size
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
     * String representation of BBQ Chicken pizza
     * @return String representation of BBQ Chicken pizza with its crust, toppings, size, and price details
     */
    @Override
    public String toString() {
        return "BBQ Chicken ("+getCrust()+") "+getToppings().toString()+", "+getSize().toString().toLowerCase()+", "+price();
    }
}
