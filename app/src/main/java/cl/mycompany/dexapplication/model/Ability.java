package cl.mycompany.dexapplication.model;

/**
 * Created by Matias on 4/22/2016.
 */
public class Ability {
    String name;
    String description;
    int hidden;

    public Ability(String name, String description, int hidden) {
        this.name = name;
        this.description = description;
        this.hidden = hidden;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHidden() {
        return hidden;
    }

    public void setHidden(int hidden) {
        this.hidden = hidden;
    }
}
