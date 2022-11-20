package model;

import java.util.ArrayList;

public class Deluxe extends Pizza{




    final static double SMALL_PRICE=14.99;
    final static double MEDIUM_PRICE=16.99;
    final static double LARGE_PRICE=18.99;


    public Deluxe(){

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
}
