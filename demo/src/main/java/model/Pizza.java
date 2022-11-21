package model;


import java.util.ArrayList;

public abstract class Pizza implements Customizable {
    private ArrayList<Topping> toppings;
    private Crust crust;
    private Size size;


    public Pizza(){

    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    public String getStringRep(){
        String res = "";

        for(int i = 0; i < toppings.size(); i++){
            res += toppings.get(i).toString();
            if(i < toppings.size()-1){
                res+= ",";
            }
            res+=" ";
        }

        res+= this.size.name().toLowerCase()+", ";


        return res;
    }

    // getters & Setters
    public void setToppings(ArrayList<Topping> toppings) {
        this.toppings = toppings;
    }

    public Crust getCrust() {
        return crust;
    }

    public void setCrust(Crust crust) {
        this.crust = crust;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }


    public abstract double price();


}