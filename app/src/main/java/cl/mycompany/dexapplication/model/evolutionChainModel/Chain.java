
package cl.mycompany.dexapplication.model.evolutionChainModel;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Chain {

    @SerializedName("is_baby")
    @Expose
    private Boolean isBaby;
    @SerializedName("species")
    @Expose
    private Species species;
    @SerializedName("evolution_details")
    @Expose
    private Object evolutionDetails;
    @SerializedName("evolves_to")
    @Expose
    private List<EvolvesTo> evolvesTo = new ArrayList<EvolvesTo>();

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
    public Species getSpecies() {
        return species;
    }

    /**
     * 
     * @param species
     *     The species
     */
    public void setSpecies(Species species) {
        this.species = species;
    }

    /**
     * 
     * @return
     *     The evolutionDetails
     */
    public Object getEvolutionDetails() {
        return evolutionDetails;
    }

    /**
     * 
     * @param evolutionDetails
     *     The evolution_details
     */
    public void setEvolutionDetails(Object evolutionDetails) {
        this.evolutionDetails = evolutionDetails;
    }

    /**
     * 
     * @return
     *     The evolvesTo
     */
    public List<EvolvesTo> getEvolvesTo() {
        return evolvesTo;
    }

    /**
     * 
     * @param evolvesTo
     *     The evolves_to
     */
    public void setEvolvesTo(List<EvolvesTo> evolvesTo) {
        this.evolvesTo = evolvesTo;
    }

}
