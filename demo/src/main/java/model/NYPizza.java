package model;
/**
 * This class serves as the model of a NY pizza and handles appropriate properties of the pizza.
 * @author Devam Patel, Rishi Patel

 */
public class NYPizza implements PizzaFactory{

    /**
     * Method that creates a Deluxe pizza and returns its instance
     * @return instance of a newly created deluxe pizza
     */

    @Override
    public Pizza createDeluxe() {
        Deluxe deluxe = new Deluxe();
        return deluxe;
    }

    /**
     * Method that creates a meatzza pizza and returns its instance
     * @return instance of a newly created meatzza pizza
     */
    @Override
    public Pizza createMeatzza() {
        Meatzza meatzza = new Meatzza();
        return meatzza;
    }

    /**
     * Method that creates a bbq chicken pizza and returns its instance
     * @return instance of a newly created bbq chicken pizza
     */
    @Override
    public Pizza createBBQChicken() {
        BBQChicken bbqChicken = new BBQChicken();
        return bbqChicken;
    }


    /**
     * Method that creates a build your own pizza and returns its instance
     * @return instance of a newly created pizza
     */
    @Override
    public Pizza createBuildYourOwn() {
        BuildYourOwn buildYourOwn = new BuildYourOwn();
        return buildYourOwn;
    }

}
