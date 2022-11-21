package model;

public class BBQChicken extends Pizza{
    final static double SMALL_PRICE= 13.99;
    final static double MEDIUM_PRICE= 15.99;
    final static double LARGE_PRICE= 17.99;


    public BBQChicken(){

    }

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




        return "BBQ Chicken "+ getStringRep() +price();
    }
}
