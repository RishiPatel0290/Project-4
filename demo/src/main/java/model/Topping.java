package model;

/**
 * Class of toppings
 * @author Devam patel
 */
public class Topping {
    String name;
    public Topping(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
