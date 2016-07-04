package cl.mycompany.dexapplication.model;

/**
 * Created by Matias on 4/22/2016.
 */
public class Ability {
    int index;
    String name;
    String description;

    public Ability(int index, String name, String description) {
        this.name = name;
        this.index = index;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
