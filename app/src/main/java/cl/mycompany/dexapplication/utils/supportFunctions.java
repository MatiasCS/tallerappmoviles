package cl.mycompany.dexapplication.utils;

import android.content.Context;
import android.widget.Toast;

import java.util.StringTokenizer;

/**
 * Created by Matias on 5/21/2016.
 */
public class supportFunctions {

    public static int getIdFromURL(String abilityURL){
        StringTokenizer id = new StringTokenizer(abilityURL,"/");
        int tokenNumber = id.countTokens();
        int i = 1;
        while(i < tokenNumber) {
            id.nextToken();
            i++;
        }
        return Integer.parseInt(id.nextToken());
    }
}
