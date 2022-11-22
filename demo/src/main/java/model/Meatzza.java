package model;

public class Meatzza extends Pizza{

    private final double SMALL_PRICE = 15.99;
    private final double MEDIUM_PRICE = 17.99;
    private final double LARGE_PRICE = 19.99;



    @Override
    public boolean add(Object obj) {
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        return false;
    }

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


    @Override
    public String toString() {
        return "Meatzza ("+getCrust()+") "+getToppings().toString()+", "+getSize().toString().toLowerCase()+", "+price();
    }
}
