package cl.mycompany.dexapplication.model;

/**
 * Created by Matias on 4/16/2016.
 */
public class Pokemon {
    private int number;
    private String name;

    public Pokemon(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
