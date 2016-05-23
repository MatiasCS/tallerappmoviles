
package cl.mycompany.dexapplication.model.typeModel;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Type {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("damage_relations")
    @Expose
    private DamageRelations damageRelations;
    @SerializedName("game_indices")
    @Expose
    private List<GameIndex> gameIndices = new ArrayList<GameIndex>();
    @SerializedName("generation")
    @Expose
    private Generation_ generation;
    @SerializedName("move_damage_class")
    @Expose
    private MoveDamageClass moveDamageClass;
    @SerializedName("names")
    @Expose
    private List<Name> names = new ArrayList<Name>();
    @SerializedName("pokemon")
    @Expose
    private List<Pokemon> pokemon = new ArrayList<Pokemon>();
    @SerializedName("moves")
    @Expose
    private List<Move> moves = new ArrayList<Move>();

    /**
     * 
     * @return
     *     The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The damageRelations
     */
    public DamageRelations getDamageRelations() {
        return damageRelations;
    }

    /**
     * 
     * @param damageRelations
     *     The damage_relations
     */
    public void setDamageRelations(DamageRelations damageRelations) {
        this.damageRelations = damageRelations;
    }

    /**
     * 
     * @return
     *     The gameIndices
     */
    public List<GameIndex> getGameIndices() {
        return gameIndices;
    }

    /**
     * 
     * @param gameIndices
     *     The game_indices
     */
    public void setGameIndices(List<GameIndex> gameIndices) {
        this.gameIndices = gameIndices;
    }

    /**
     * 
     * @return
     *     The generation
     */
    public Generation_ getGeneration() {
        return generation;
    }

    /**
     * 
     * @param generation
     *     The generation
     */
    public void setGeneration(Generation_ generation) {
        this.generation = generation;
    }

    /**
     * 
     * @return
     *     The moveDamageClass
     */
    public MoveDamageClass getMoveDamageClass() {
        return moveDamageClass;
    }

    /**
     * 
     * @param moveDamageClass
     *     The move_damage_class
     */
    public void setMoveDamageClass(MoveDamageClass moveDamageClass) {
        this.moveDamageClass = moveDamageClass;
    }

    /**
     * 
     * @return
     *     The names
     */
    public List<Name> getNames() {
        return names;
    }

    /**
     * 
     * @param names
     *     The names
     */
    public void setNames(List<Name> names) {
        this.names = names;
    }

    /**
     * 
     * @return
     *     The pokemon
     */
    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    /**
     * 
     * @param pokemon
     *     The pokemon
     */
    public void setPokemon(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }

    /**
     * 
     * @return
     *     The moves
     */
    public List<Move> getMoves() {
        return moves;
    }

    /**
     * 
     * @param moves
     *     The moves
     */
    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

}
