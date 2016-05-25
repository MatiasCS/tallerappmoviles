
package cl.mycompany.dexapplication.model.moveModel;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class StatChange {

    @SerializedName("change")
    @Expose
    private Integer change;
    @SerializedName("stat")
    @Expose
    private Stat stat;

    /**
     * 
     * @return
     *     The change
     */
    public Integer getChange() {
        return change;
    }

    /**
     * 
     * @param change
     *     The change
     */
    public void setChange(Integer change) {
        this.change = change;
    }

    /**
     * 
     * @return
     *     The stat
     */
    public Stat getStat() {
        return stat;
    }

    /**
     * 
     * @param stat
     *     The stat
     */
    public void setStat(Stat stat) {
        this.stat = stat;
    }

}
