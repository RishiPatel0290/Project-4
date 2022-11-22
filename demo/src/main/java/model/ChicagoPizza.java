package model;

public class ChicagoPizza implements PizzaFactory{



    @Override
    public Pizza createDeluxe() {
        Deluxe deluxe = new Deluxe();
        return deluxe;
    }

    @Override
    public Pizza createMeatzza() {
        Meatzza meatzza = new Meatzza();
        return meatzza;
    }

    @Override
    public Pizza createBBQChicken() {
        BBQChicken bbqChicken = new BBQChicken();
        return bbqChicken;
    }

    @Override
    public Pizza createBuildYourOwn() {
        BuildYourOwn buildYourOwn = new BuildYourOwn();
        return buildYourOwn;
    }



}
