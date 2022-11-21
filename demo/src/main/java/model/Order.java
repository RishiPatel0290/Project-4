package model;

import java.util.ArrayList;

public class Order implements Customizable{

    private int orderNumber;


    private ArrayList<Pizza>orderedItems;










    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }






    @Override
    public boolean add(Object obj) {
        Pizza toBeAdded = (Pizza) obj;
        return orderedItems.add(toBeAdded);

    }


    // might have issue while finding correct pizza
    @Override
    public boolean remove(Object obj) {
        Pizza toBeRemoved = (Pizza) obj;
        return  orderedItems.remove(toBeRemoved);
    }
}
