package model;

import java.util.ArrayList;

public class StoreOrder implements Customizable{

    private ArrayList<Order> storeOrders;

    public ArrayList<Order> getStoreOrders() {
        return storeOrders;
    }

    @Override
    public boolean add(Object obj) {

        if(storeOrders==null){
            storeOrders = new ArrayList<>();
        }

        return storeOrders.add((Order) obj);

    }

    @Override
    public boolean remove(Object obj) {
        return storeOrders.remove((Order) obj);
    }

}
