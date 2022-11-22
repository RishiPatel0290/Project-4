package model;
/**
 * This class serves as the model of a meatzza pizza and handles appropriate properties of the pizza.
 * @author Devam Patel, Rishi Patel
 */
public class Meatzza extends Pizza{

    private final double SMALL_PRICE = 15.99;
    private final double MEDIUM_PRICE = 17.99;
    private final double LARGE_PRICE = 19.99;



    /**
     * overrides the pizza class method for add
     * @param obj Object to add to meatzza
     * @return false, as no use in this case.
     */
    @Override
    public boolean add(Object obj) {
        return false;
    }

    /**
     * overrides the pizza class method for remove
     * @param obj Object to remove to meatzza
     * @return false, as no use in this case.
     */
    @Override
    public boolean remove(Object obj) {
        return false;
    }

    /**
     * computes the price of the pizza based on size
     * @return double price of a meatzza pizza based on its size
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
     * String representation of meatzza pizza
     * @return String representation of a meatzza pizza with its crust, toppings, size, and price details
     */
    @Override
    public String toString() {
        return "Meatzza ("+getCrust()+") "+getToppings().toString()+", "+getSize().toString().toLowerCase()+", "+price();
    }
}
