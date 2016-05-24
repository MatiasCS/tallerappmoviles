
package cl.mycompany.dexapplication.model.evolutionChainModel;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class EvolutionChain {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("baby_trigger_item")
    @Expose
    private Object babyTriggerItem;
    @SerializedName("chain")
    @Expose
    private Chain chain;

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
     *     The babyTriggerItem
     */
    public Object getBabyTriggerItem() {
        return babyTriggerItem;
    }

    /**
     * 
     * @param babyTriggerItem
     *     The baby_trigger_item
     */
    public void setBabyTriggerItem(Object babyTriggerItem) {
        this.babyTriggerItem = babyTriggerItem;
    }

    /**
     * 
     * @return
     *     The chain
     */
    public Chain getChain() {
        return chain;
    }

    /**
     * 
     * @param chain
     *     The chain
     */
    public void setChain(Chain chain) {
        this.chain = chain;
    }

}
