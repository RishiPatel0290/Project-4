package model;

import java.util.ArrayList;

public class StoreOrder implements Customizable{

    private ArrayList<Order> storeOrders;

    @Override
    public boolean add(Object obj) {
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        return false;
    }

}
