package model;


/**
 * Class that serves as the model of the Crust of a pizza
 */
public class Crust {




    private String crustName;

    /**
     * Constructor of the Crust class to set the curstName property
     * @param text String value of the crustName field for this object
     */
    public Crust(String text) {
        this.crustName = text;
    }

    /**
     * String representation of the Crust class
     * @return String representation of the Crust class
     */
    @Override
    public String toString() {
        return this.crustName;
    }
}
