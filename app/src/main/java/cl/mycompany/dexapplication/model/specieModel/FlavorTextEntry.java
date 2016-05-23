
package cl.mycompany.dexapplication.model.specieModel;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class FlavorTextEntry {

    @SerializedName("flavor_text")
    @Expose
    private String flavorText;
    @SerializedName("language")
    @Expose
    private Language_ language;
    @SerializedName("version")
    @Expose
    private Version version;

    /**
     * 
     * @return
     *     The flavorText
     */
    public String getFlavorText() {
        return flavorText;
    }

    /**
     * 
     * @param flavorText
     *     The flavor_text
     */
    public void setFlavorText(String flavorText) {
        this.flavorText = flavorText;
    }

    /**
     * 
     * @return
     *     The language
     */
    public Language_ getLanguage() {
        return language;
    }

    /**
     * 
     * @param language
     *     The language
     */
    public void setLanguage(Language_ language) {
        this.language = language;
    }

    /**
     * 
     * @return
     *     The version
     */
    public Version getVersion() {
        return version;
    }

    /**
     * 
     * @param version
     *     The version
     */
    public void setVersion(Version version) {
        this.version = version;
    }

}
