package cl.mycompany.dexapplication.model;

/**
 * Created by Matias on 5/4/2016.
 */
public class Move {
    private int number;
    private String name;
    private String type;
    private int PP;
    private int power;
    private int accuracy;

    public Move(int number, String name, String type, int PP, int power, int accuracy) {
        this.number = number;
        this.name = name;
        this.type = type;
        this.PP = PP;
        this.power = power;
        this.accuracy = accuracy;
    }

    public int getNumber() {
        return number;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getPP() {
        return PP;
    }

    public void setPP(int PP) {
        this.PP = PP;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
