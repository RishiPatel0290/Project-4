package model;

public class NYPizza extends Pizza implements PizzaFactory{
    @Override
    public Pizza createDeluxe() {
        return null;
    }

    @Override
    public Pizza createMeatzza() {
        return null;
    }

    @Override
    public Pizza createBBQChicken() {
        return null;
    }

    @Override
    public Pizza createBuildYourOwn() {
        return null;
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
        return 0;
    }
}
