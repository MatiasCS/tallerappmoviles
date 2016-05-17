package cl.mycompany.dexapplication.model;

/**
 * Created by Matias on 5/4/2016.
 */
public class Move {
    private String name;
    private String type;
    private int PP;
    private int attack;
    private int accuaracy;
    private int levelLearned;
    private String description;

    public Move(String name, String type, int PP, int attack, int accuaracy, int levelLearned, String description) {
        this.name = name;
        this.type = type;
        this.PP = PP;
        this.attack = attack;
        this.accuaracy = accuaracy;
        this.levelLearned = levelLearned;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPP() {
        return PP;
    }

    public void setPP(int PP) {
        this.PP = PP;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getAccuaracy() {
        return accuaracy;
    }

    public void setAccuaracy(int accuaracy) {
        this.accuaracy = accuaracy;
    }

    public int getLevelLearned() {
        return levelLearned;
    }

    public void setLevelLearned(int levelLearned) {
        this.levelLearned = levelLearned;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
