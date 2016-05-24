
package cl.mycompany.dexapplication.model.evolutionChainModel;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class EvolvesTo {

    @SerializedName("is_baby")
    @Expose
    private Boolean isBaby;
    @SerializedName("species")
    @Expose
    private Species_ species;
    @SerializedName("evolution_details")
    @Expose
    private EvolutionDetails evolutionDetails;
    @SerializedName("evolves_to")
    @Expose
    private List<EvolvesTo_> evolvesTo = new ArrayList<EvolvesTo_>();

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
    public Species_ getSpecies() {
        return species;
    }

    /**
     * 
     * @param species
     *     The species
     */
    public void setSpecies(Species_ species) {
        this.species = species;
    }

    /**
     * 
     * @return
     *     The evolutionDetails
     */
    public EvolutionDetails getEvolutionDetails() {
        return evolutionDetails;
    }

    /**
     * 
     * @param evolutionDetails
     *     The evolution_details
     */
    public void setEvolutionDetails(EvolutionDetails evolutionDetails) {
        this.evolutionDetails = evolutionDetails;
    }

    /**
     * 
     * @return
     *     The evolvesTo
     */
    public List<EvolvesTo_> getEvolvesTo() {
        return evolvesTo;
    }

    /**
     * 
     * @param evolvesTo
     *     The evolves_to
     */
    public void setEvolvesTo(List<EvolvesTo_> evolvesTo) {
        this.evolvesTo = evolvesTo;
    }

}
