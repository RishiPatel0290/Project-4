package model;

public class ChicagoPizza extends Pizza implements PizzaFactory{



    private double price;
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
