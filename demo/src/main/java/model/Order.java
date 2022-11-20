package model;

import java.util.ArrayList;

public class Order implements Customizable{

    private int orderNumber;
    private ArrayList<Pizza>orderedItems;

    @Override
    public boolean add(Object obj) {
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        return false;
    }
}
