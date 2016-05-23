
package cl.mycompany.dexapplication.model.specieModel;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Genera {

    @SerializedName("genus")
    @Expose
    private String genus;
    @SerializedName("language")
    @Expose
    private Language__ language;

    /**
     * 
     * @return
     *     The genus
     */
    public String getGenus() {
        return genus;
    }

    /**
     * 
     * @param genus
     *     The genus
     */
    public void setGenus(String genus) {
        this.genus = genus;
    }

    /**
     * 
     * @return
     *     The language
     */
    public Language__ getLanguage() {
        return language;
    }

    /**
     * 
     * @param language
     *     The language
     */
    public void setLanguage(Language__ language) {
        this.language = language;
    }

}
