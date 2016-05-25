
package cl.mycompany.dexapplication.model.moveModel;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class EffectEntry {

    @SerializedName("effect")
    @Expose
    private String effect;
    @SerializedName("short_effect")
    @Expose
    private String shortEffect;
    @SerializedName("language")
    @Expose
    private Language language;

    /**
     * 
     * @return
     *     The effect
     */
    public String getEffect() {
        return effect;
    }

    /**
     * 
     * @param effect
     *     The effect
     */
    public void setEffect(String effect) {
        this.effect = effect;
    }

    /**
     * 
     * @return
     *     The shortEffect
     */
    public String getShortEffect() {
        return shortEffect;
    }

    /**
     * 
     * @param shortEffect
     *     The short_effect
     */
    public void setShortEffect(String shortEffect) {
        this.shortEffect = shortEffect;
    }

    /**
     * 
     * @return
     *     The language
     */
    public Language getLanguage() {
        return language;
    }

    /**
     * 
     * @param language
     *     The language
     */
    public void setLanguage(Language language) {
        this.language = language;
    }

}
