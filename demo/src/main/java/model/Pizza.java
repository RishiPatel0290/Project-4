package model;


import java.util.ArrayList;

/**
 * Abstract class that serves as the generalization of pizzas with different flavors
 */
public abstract class Pizza implements Customizable {
    private ArrayList<Topping> toppings;
    private Crust crust;
    private Size size;

    /**
     * Default constructor
     */
    public Pizza(){

    }

    /**
     * return the toppings field in this instance
     * @return ArrayList<Topping> topping list of the pizza
     */
    public ArrayList<Topping> getToppings() {
        return toppings;
    }


    /**
     * set the toppings of this instance
     * @param toppings list of toppings to set to
     */
    public void setToppings(ArrayList<Topping> toppings) {
        this.toppings = toppings;
    }

    /**
     * return crust object
     * @return return crust object
     */
    public Crust getCrust() {
        return crust;
    }

    /**
     * set crust of pizza
     * @param crust set crust of pizza
     */
    public void setCrust(Crust crust) {
        this.crust = crust;
    }

    /**
     * return Size instance of pizza
     * @return return Size instance of pizza
     */
    public Size getSize() {
        return size;
    }

    /**
     * set Size of the pizza
     * @param size set Size instance of pizza
     */
    public void setSize(Size size) {
        this.size = size;
    }

    /**
     * abstract method implemented in other classes
     * @return double price amount of the class.
     */
    public abstract double price();


}