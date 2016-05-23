
package cl.mycompany.dexapplication.model.specieModel;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class PalParkEncounter {

    @SerializedName("base_score")
    @Expose
    private Integer baseScore;
    @SerializedName("rate")
    @Expose
    private Integer rate;
    @SerializedName("area")
    @Expose
    private Area area;

    /**
     * 
     * @return
     *     The baseScore
     */
    public Integer getBaseScore() {
        return baseScore;
    }

    /**
     * 
     * @param baseScore
     *     The base_score
     */
    public void setBaseScore(Integer baseScore) {
        this.baseScore = baseScore;
    }

    /**
     * 
     * @return
     *     The rate
     */
    public Integer getRate() {
        return rate;
    }

    /**
     * 
     * @param rate
     *     The rate
     */
    public void setRate(Integer rate) {
        this.rate = rate;
    }

    /**
     * 
     * @return
     *     The area
     */
    public Area getArea() {
        return area;
    }

    /**
     * 
     * @param area
     *     The area
     */
    public void setArea(Area area) {
        this.area = area;
    }

}
