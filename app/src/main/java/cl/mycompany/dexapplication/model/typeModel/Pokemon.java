
package cl.mycompany.dexapplication.model.typeModel;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Pokemon {

    @SerializedName("slot")
    @Expose
    private Integer slot;
    @SerializedName("pokemon")
    @Expose
    private Pokemon_ pokemon;

    /**
     * 
     * @return
     *     The slot
     */
    public Integer getSlot() {
        return slot;
    }

    /**
     * 
     * @param slot
     *     The slot
     */
    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    /**
     * 
     * @return
     *     The pokemon
     */
    public Pokemon_ getPokemon() {
        return pokemon;
    }

    /**
     * 
     * @param pokemon
     *     The pokemon
     */
    public void setPokemon(Pokemon_ pokemon) {
        this.pokemon = pokemon;
    }

}
