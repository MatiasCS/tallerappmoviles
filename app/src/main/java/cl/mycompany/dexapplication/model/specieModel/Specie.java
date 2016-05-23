
package cl.mycompany.dexapplication.model.specieModel;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Specie {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("order")
    @Expose
    private Integer order;
    @SerializedName("gender_rate")
    @Expose
    private Integer genderRate;
    @SerializedName("capture_rate")
    @Expose
    private Integer captureRate;
    @SerializedName("base_happiness")
    @Expose
    private Integer baseHappiness;
    @SerializedName("is_baby")
    @Expose
    private Boolean isBaby;
    @SerializedName("hatch_counter")
    @Expose
    private Integer hatchCounter;
    @SerializedName("has_gender_differences")
    @Expose
    private Boolean hasGenderDifferences;
    @SerializedName("forms_switchable")
    @Expose
    private Boolean formsSwitchable;
    @SerializedName("growth_rate")
    @Expose
    private GrowthRate growthRate;
    @SerializedName("pokedex_numbers")
    @Expose
    private List<PokedexNumber> pokedexNumbers = new ArrayList<PokedexNumber>();
    @SerializedName("egg_groups")
    @Expose
    private List<EggGroup> eggGroups = new ArrayList<EggGroup>();
    @SerializedName("color")
    @Expose
    private Color color;
    @SerializedName("shape")
    @Expose
    private Shape shape;
    @SerializedName("evolves_from_species")
    @Expose
    private Object evolvesFromSpecies;
    @SerializedName("evolution_chain")
    @Expose
    private EvolutionChain evolutionChain;
    @SerializedName("habitat")
    @Expose
    private Habitat habitat;
    @SerializedName("generation")
    @Expose
    private Generation generation;
    @SerializedName("names")
    @Expose
    private List<Name> names = new ArrayList<Name>();
    @SerializedName("pal_park_encounters")
    @Expose
    private List<PalParkEncounter> palParkEncounters = new ArrayList<PalParkEncounter>();
    @SerializedName("form_descriptions")
    @Expose
    private List<Object> formDescriptions = new ArrayList<Object>();
    @SerializedName("flavor_text_entries")
    @Expose
    private List<FlavorTextEntry> flavorTextEntries = new ArrayList<FlavorTextEntry>();
    @SerializedName("genera")
    @Expose
    private List<Genera> genera = new ArrayList<Genera>();
    @SerializedName("varieties")
    @Expose
    private List<Variety> varieties = new ArrayList<Variety>();

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
     *     The order
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * 
     * @param order
     *     The order
     */
    public void setOrder(Integer order) {
        this.order = order;
    }

    /**
     * 
     * @return
     *     The genderRate
     */
    public Integer getGenderRate() {
        return genderRate;
    }

    /**
     * 
     * @param genderRate
     *     The gender_rate
     */
    public void setGenderRate(Integer genderRate) {
        this.genderRate = genderRate;
    }

    /**
     * 
     * @return
     *     The captureRate
     */
    public Integer getCaptureRate() {
        return captureRate;
    }

    /**
     * 
     * @param captureRate
     *     The capture_rate
     */
    public void setCaptureRate(Integer captureRate) {
        this.captureRate = captureRate;
    }

    /**
     * 
     * @return
     *     The baseHappiness
     */
    public Integer getBaseHappiness() {
        return baseHappiness;
    }

    /**
     * 
     * @param baseHappiness
     *     The base_happiness
     */
    public void setBaseHappiness(Integer baseHappiness) {
        this.baseHappiness = baseHappiness;
    }

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
     *     The hatchCounter
     */
    public Integer getHatchCounter() {
        return hatchCounter;
    }

    /**
     * 
     * @param hatchCounter
     *     The hatch_counter
     */
    public void setHatchCounter(Integer hatchCounter) {
        this.hatchCounter = hatchCounter;
    }

    /**
     * 
     * @return
     *     The hasGenderDifferences
     */
    public Boolean getHasGenderDifferences() {
        return hasGenderDifferences;
    }

    /**
     * 
     * @param hasGenderDifferences
     *     The has_gender_differences
     */
    public void setHasGenderDifferences(Boolean hasGenderDifferences) {
        this.hasGenderDifferences = hasGenderDifferences;
    }

    /**
     * 
     * @return
     *     The formsSwitchable
     */
    public Boolean getFormsSwitchable() {
        return formsSwitchable;
    }

    /**
     * 
     * @param formsSwitchable
     *     The forms_switchable
     */
    public void setFormsSwitchable(Boolean formsSwitchable) {
        this.formsSwitchable = formsSwitchable;
    }

    /**
     * 
     * @return
     *     The growthRate
     */
    public GrowthRate getGrowthRate() {
        return growthRate;
    }

    /**
     * 
     * @param growthRate
     *     The growth_rate
     */
    public void setGrowthRate(GrowthRate growthRate) {
        this.growthRate = growthRate;
    }

    /**
     * 
     * @return
     *     The pokedexNumbers
     */
    public List<PokedexNumber> getPokedexNumbers() {
        return pokedexNumbers;
    }

    /**
     * 
     * @param pokedexNumbers
     *     The pokedex_numbers
     */
    public void setPokedexNumbers(List<PokedexNumber> pokedexNumbers) {
        this.pokedexNumbers = pokedexNumbers;
    }

    /**
     * 
     * @return
     *     The eggGroups
     */
    public List<EggGroup> getEggGroups() {
        return eggGroups;
    }

    /**
     * 
     * @param eggGroups
     *     The egg_groups
     */
    public void setEggGroups(List<EggGroup> eggGroups) {
        this.eggGroups = eggGroups;
    }

    /**
     * 
     * @return
     *     The color
     */
    public Color getColor() {
        return color;
    }

    /**
     * 
     * @param color
     *     The color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * 
     * @return
     *     The shape
     */
    public Shape getShape() {
        return shape;
    }

    /**
     * 
     * @param shape
     *     The shape
     */
    public void setShape(Shape shape) {
        this.shape = shape;
    }

    /**
     * 
     * @return
     *     The evolvesFromSpecies
     */
    public Object getEvolvesFromSpecies() {
        return evolvesFromSpecies;
    }

    /**
     * 
     * @param evolvesFromSpecies
     *     The evolves_from_species
     */
    public void setEvolvesFromSpecies(Object evolvesFromSpecies) {
        this.evolvesFromSpecies = evolvesFromSpecies;
    }

    /**
     * 
     * @return
     *     The evolutionChain
     */
    public EvolutionChain getEvolutionChain() {
        return evolutionChain;
    }

    /**
     * 
     * @param evolutionChain
     *     The evolution_chain
     */
    public void setEvolutionChain(EvolutionChain evolutionChain) {
        this.evolutionChain = evolutionChain;
    }

    /**
     * 
     * @return
     *     The habitat
     */
    public Habitat getHabitat() {
        return habitat;
    }

    /**
     * 
     * @param habitat
     *     The habitat
     */
    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }

    /**
     * 
     * @return
     *     The generation
     */
    public Generation getGeneration() {
        return generation;
    }

    /**
     * 
     * @param generation
     *     The generation
     */
    public void setGeneration(Generation generation) {
        this.generation = generation;
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
     *     The palParkEncounters
     */
    public List<PalParkEncounter> getPalParkEncounters() {
        return palParkEncounters;
    }

    /**
     * 
     * @param palParkEncounters
     *     The pal_park_encounters
     */
    public void setPalParkEncounters(List<PalParkEncounter> palParkEncounters) {
        this.palParkEncounters = palParkEncounters;
    }

    /**
     * 
     * @return
     *     The formDescriptions
     */
    public List<Object> getFormDescriptions() {
        return formDescriptions;
    }

    /**
     * 
     * @param formDescriptions
     *     The form_descriptions
     */
    public void setFormDescriptions(List<Object> formDescriptions) {
        this.formDescriptions = formDescriptions;
    }

    /**
     * 
     * @return
     *     The flavorTextEntries
     */
    public List<FlavorTextEntry> getFlavorTextEntries() {
        return flavorTextEntries;
    }

    /**
     * 
     * @param flavorTextEntries
     *     The flavor_text_entries
     */
    public void setFlavorTextEntries(List<FlavorTextEntry> flavorTextEntries) {
        this.flavorTextEntries = flavorTextEntries;
    }

    /**
     * 
     * @return
     *     The genera
     */
    public List<Genera> getGenera() {
        return genera;
    }

    /**
     * 
     * @param genera
     *     The genera
     */
    public void setGenera(List<Genera> genera) {
        this.genera = genera;
    }

    /**
     * 
     * @return
     *     The varieties
     */
    public List<Variety> getVarieties() {
        return varieties;
    }

    /**
     * 
     * @param varieties
     *     The varieties
     */
    public void setVarieties(List<Variety> varieties) {
        this.varieties = varieties;
    }

}
