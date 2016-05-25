
package cl.mycompany.dexapplication.model.moveModel;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Move {

    //added apart

    private int levelLearned;

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("accuracy")
    @Expose
    private Integer accuracy;
    @SerializedName("effect_chance")
    @Expose
    private Object effectChance;
    @SerializedName("pp")
    @Expose
    private Integer pp;
    @SerializedName("priority")
    @Expose
    private Integer priority;
    @SerializedName("power")
    @Expose
    private Integer power;
    @SerializedName("contest_combos")
    @Expose
    private Object contestCombos;
    @SerializedName("contest_type")
    @Expose
    private ContestType contestType;
    @SerializedName("contest_effect")
    @Expose
    private Object contestEffect;
    @SerializedName("damage_class")
    @Expose
    private DamageClass damageClass;
    @SerializedName("effect_entries")
    @Expose
    private List<EffectEntry> effectEntries = new ArrayList<EffectEntry>();
    @SerializedName("effect_changes")
    @Expose
    private List<Object> effectChanges = new ArrayList<Object>();
    @SerializedName("generation")
    @Expose
    private Generation generation;
    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("names")
    @Expose
    private List<Name> names = new ArrayList<Name>();
    @SerializedName("past_values")
    @Expose
    private List<Object> pastValues = new ArrayList<Object>();
    @SerializedName("stat_changes")
    @Expose
    private List<StatChange> statChanges = new ArrayList<StatChange>();
    @SerializedName("super_contest_effect")
    @Expose
    private SuperContestEffect superContestEffect;
    @SerializedName("target")
    @Expose
    private Target target;
    @SerializedName("type")
    @Expose
    private Type type;

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
     *     The accuracy
     */
    public Integer getAccuracy() {
        return accuracy;
    }

    /**
     * 
     * @param accuracy
     *     The accuracy
     */
    public void setAccuracy(Integer accuracy) {
        this.accuracy = accuracy;
    }

    /**
     * 
     * @return
     *     The effectChance
     */
    public Object getEffectChance() {
        return effectChance;
    }

    /**
     * 
     * @param effectChance
     *     The effect_chance
     */
    public void setEffectChance(Object effectChance) {
        this.effectChance = effectChance;
    }

    /**
     * 
     * @return
     *     The pp
     */
    public Integer getPp() {
        return pp;
    }

    /**
     * 
     * @param pp
     *     The pp
     */
    public void setPp(Integer pp) {
        this.pp = pp;
    }

    /**
     * 
     * @return
     *     The priority
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * 
     * @param priority
     *     The priority
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * 
     * @return
     *     The power
     */
    public Integer getPower() {
        return power;
    }

    /**
     * 
     * @param power
     *     The power
     */
    public void setPower(Integer power) {
        this.power = power;
    }

    /**
     * 
     * @return
     *     The contestCombos
     */
    public Object getContestCombos() {
        return contestCombos;
    }

    /**
     * 
     * @param contestCombos
     *     The contest_combos
     */
    public void setContestCombos(Object contestCombos) {
        this.contestCombos = contestCombos;
    }

    /**
     * 
     * @return
     *     The contestType
     */
    public ContestType getContestType() {
        return contestType;
    }

    /**
     * 
     * @param contestType
     *     The contest_type
     */
    public void setContestType(ContestType contestType) {
        this.contestType = contestType;
    }

    /**
     * 
     * @return
     *     The contestEffect
     */
    public Object getContestEffect() {
        return contestEffect;
    }

    /**
     * 
     * @param contestEffect
     *     The contest_effect
     */
    public void setContestEffect(Object contestEffect) {
        this.contestEffect = contestEffect;
    }

    /**
     * 
     * @return
     *     The damageClass
     */
    public DamageClass getDamageClass() {
        return damageClass;
    }

    /**
     * 
     * @param damageClass
     *     The damage_class
     */
    public void setDamageClass(DamageClass damageClass) {
        this.damageClass = damageClass;
    }

    /**
     * 
     * @return
     *     The effectEntries
     */
    public List<EffectEntry> getEffectEntries() {
        return effectEntries;
    }

    /**
     * 
     * @param effectEntries
     *     The effect_entries
     */
    public void setEffectEntries(List<EffectEntry> effectEntries) {
        this.effectEntries = effectEntries;
    }

    /**
     * 
     * @return
     *     The effectChanges
     */
    public List<Object> getEffectChanges() {
        return effectChanges;
    }

    /**
     * 
     * @param effectChanges
     *     The effect_changes
     */
    public void setEffectChanges(List<Object> effectChanges) {
        this.effectChanges = effectChanges;
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
     *     The meta
     */
    public Meta getMeta() {
        return meta;
    }

    /**
     * 
     * @param meta
     *     The meta
     */
    public void setMeta(Meta meta) {
        this.meta = meta;
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
     *     The pastValues
     */
    public List<Object> getPastValues() {
        return pastValues;
    }

    /**
     * 
     * @param pastValues
     *     The past_values
     */
    public void setPastValues(List<Object> pastValues) {
        this.pastValues = pastValues;
    }

    /**
     * 
     * @return
     *     The statChanges
     */
    public List<StatChange> getStatChanges() {
        return statChanges;
    }

    /**
     * 
     * @param statChanges
     *     The stat_changes
     */
    public void setStatChanges(List<StatChange> statChanges) {
        this.statChanges = statChanges;
    }

    /**
     * 
     * @return
     *     The superContestEffect
     */
    public SuperContestEffect getSuperContestEffect() {
        return superContestEffect;
    }

    /**
     * 
     * @param superContestEffect
     *     The super_contest_effect
     */
    public void setSuperContestEffect(SuperContestEffect superContestEffect) {
        this.superContestEffect = superContestEffect;
    }

    /**
     * 
     * @return
     *     The target
     */
    public Target getTarget() {
        return target;
    }

    /**
     * 
     * @param target
     *     The target
     */
    public void setTarget(Target target) {
        this.target = target;
    }

    /**
     * 
     * @return
     *     The type
     */
    public Type getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(Type type) {
        this.type = type;
    }

    //added

    public int getLevelLearned(){
        return levelLearned;
    }

    public void setLevelLearned(int levelLearned){
        this.levelLearned = levelLearned;
    }

}
