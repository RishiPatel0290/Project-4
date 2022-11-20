package model;

public class BuildYourOwn extends Pizza{

    private final double SMALL_PRICE = 8.99;
    private final double MEDIUM_PRICE = 10.99;
    private final double LARGE_PRICE = 12.99;


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
        double price = 0;
        if(getSize()==Size.SMALL){
            price+=SMALL_PRICE;
        }else if(getSize()==Size.MEDIUM){
            price+=MEDIUM_PRICE;
        }else{
            price+=LARGE_PRICE;
        }

        if(getToppings()!=null){
            price+= (getToppings().size()*1.59);
        }


        return  price;

    }
}