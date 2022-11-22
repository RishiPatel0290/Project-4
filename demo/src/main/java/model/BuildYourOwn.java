package model;

/**
 * This class serves as the model of a build your own pizza and handles appropriate properties of the pizza.
 * @author Devam Patel, Rishi Patel
 */
public class BuildYourOwn extends Pizza{

    private final double SMALL_PRICE = 8.99;
    private final double MEDIUM_PRICE = 10.99;
    private final double LARGE_PRICE = 12.99;


    /**
     * overrides the pizza class method for add
     * @param obj Object to add to pizza
     * @return false, as no use in this case.
     */
    @Override
    public boolean add(Object obj) {
        return false;
    }

    /**
     * overrides the pizza class method for remove
     * @param obj Object to remove in pizza
     * @return false, as no use in this case.
     */
    @Override
    public boolean remove(Object obj) {
        return false;
    }

    /**
     * computes the price of the pizza based on size
     * @return double price of a build your own pizza based on its size and toppings
     */
    @Override
    public double price() {
        double price = 0;
        if(getSize()==Size.SMALL){
            price+=SMALL_PRICE;
        }else if(getSize()==Size.MEDIUM){
            price+=MEDIUM_PRICE;
        }else{
            price+=LARGE_PRICE;
        }
        if(getToppings()!=null) {
            price+= (getToppings().size()*1.59);
        }


        return  price;

    }

    /**
     * String representation of a build your own pizza
     * @return String representation of Build your own pizza with its crust, toppings, size, and price details
     */
    @Override
    public String toString() {
        if(getToppings().size()==0){
            return "Build Your Own -- No Toppings --"+", "+getSize().toString().toLowerCase()+", "+price();
        }
        return "Build Your Own ("+getCrust()+") "+getToppings().toString()+", "+getSize().toString().toLowerCase()+", "+price();
    }
}