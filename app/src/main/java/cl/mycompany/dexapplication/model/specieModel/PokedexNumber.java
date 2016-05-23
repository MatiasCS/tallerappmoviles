
package cl.mycompany.dexapplication.model.specieModel;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class PokedexNumber {

    @SerializedName("entry_number")
    @Expose
    private Integer entryNumber;
    @SerializedName("pokedex")
    @Expose
    private Pokedex pokedex;

    /**
     * 
     * @return
     *     The entryNumber
     */
    public Integer getEntryNumber() {
        return entryNumber;
    }

    /**
     * 
     * @param entryNumber
     *     The entry_number
     */
    public void setEntryNumber(Integer entryNumber) {
        this.entryNumber = entryNumber;
    }

    /**
     * 
     * @return
     *     The pokedex
     */
    public Pokedex getPokedex() {
        return pokedex;
    }

    /**
     * 
     * @param pokedex
     *     The pokedex
     */
    public void setPokedex(Pokedex pokedex) {
        this.pokedex = pokedex;
    }

}
