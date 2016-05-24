
package cl.mycompany.dexapplication.model.evolutionChainModel;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class EvolvesTo_ {

    @SerializedName("is_baby")
    @Expose
    private Boolean isBaby;
    @SerializedName("species")
    @Expose
    private Species__ species;
    @SerializedName("evolution_details")
    @Expose
    private EvolutionDetails_ evolutionDetails;
    @SerializedName("evolves_to")
    @Expose
    private List<Object> evolvesTo = new ArrayList<Object>();

    /**
     * 
     * @return
     *     The isBaby
     */
    public Boolean getIsBaby() {
        return isBaby;
    }

    /**
     * 
     * @param isBaby
     *     The is_baby
     */
    public void setIsBaby(Boolean isBaby) {
        this.isBaby = isBaby;
    }

    /**
     * 
     * @return
     *     The species
     */
    public Species__ getSpecies() {
        return species;
    }

    /**
     * 
     * @param species
     *     The species
     */
    public void setSpecies(Species__ species) {
        this.species = species;
    }

    /**
     * 
     * @return
     *     The evolutionDetails
     */
    public EvolutionDetails_ getEvolutionDetails() {
        return evolutionDetails;
    }

    /**
     * 
     * @param evolutionDetails
     *     The evolution_details
     */
    public void setEvolutionDetails(EvolutionDetails_ evolutionDetails) {
        this.evolutionDetails = evolutionDetails;
    }

    /**
     * 
     * @return
     *     The evolvesTo
     */
    public List<Object> getEvolvesTo() {
        return evolvesTo;
    }

    /**
     * 
     * @param evolvesTo
     *     The evolves_to
     */
    public void setEvolvesTo(List<Object> evolvesTo) {
        this.evolvesTo = evolvesTo;
    }

}
