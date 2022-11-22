package test;

import model.BuildYourOwn;
import model.Pizza;
import model.Size;
import model.Topping;
import org.junit.Test;

import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

public class BuildYourOwnTest {


    // 0 topping so basic price is given based on size
    @Test
    public void noTopping() {
        Pizza pizza = new BuildYourOwn();
        pizza.setSize(Size.SMALL);
        ArrayList<Topping> toppings = new ArrayList<>();
        pizza.setToppings(toppings);
        // Size = Small
        assertEquals(8.99, pizza.price(),0);;
        pizza.setSize(Size.MEDIUM);
        // Size  = Medium;
        assertEquals(10.99, pizza.price(),0);;
        pizza.setSize(Size.LARGE);
        // Size = Large
        assertEquals(12.99, pizza.price(),0);;
    }




    // one topping means additional $1.59 on top of basic price given based on size
    @Test
    public void oneTopping() {
        Pizza pizza = new BuildYourOwn();
        pizza.setSize(Size.SMALL);
        ArrayList<Topping> toppings = new ArrayList<>();
        toppings.add(new Topping("Sausage"));
        pizza.setToppings(toppings);
        // Size = Small
        assertEquals(10.58, pizza.price(),0);;
        pizza.setSize(Size.MEDIUM);
        // Size  = Medium;
        assertEquals(12.58, pizza.price(),0);;
        pizza.setSize(Size.LARGE);
        // Size = Large
        assertEquals(14.58, pizza.price(),0);;
    }

    @Test
    public void sevenToppings(){
        Pizza pizza = new BuildYourOwn();
        pizza.setSize(Size.SMALL);
        ArrayList<Topping> toppings = new ArrayList<>();
        toppings.add(new Topping("Sausage"));
        toppings.add(new Topping("cheddar"));
        toppings.add(new Topping("provolone"));
        toppings.add(new Topping("beef"));
        toppings.add(new Topping("ham"));
        toppings.add(new Topping("green pepper"));
        toppings.add(new Topping("pepperoni"));
        pizza.setToppings(toppings);
        // Size = Small
        assertEquals(20.12, pizza.price(),0);;
        pizza.setSize(Size.MEDIUM);
        // Size  = Medium;
        assertEquals(22.12, pizza.price(),0);;
        pizza.setSize(Size.LARGE);
        // Size = Large
        assertEquals(24.12, pizza.price(),0);;
    }



}