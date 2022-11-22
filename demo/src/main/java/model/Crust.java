package model;

public class Crust {




    private String crustName;

    public Crust(String text) {
        this.crustName = text;
    }


    @Override
    public String toString() {
        return this.crustName;
    }
}
