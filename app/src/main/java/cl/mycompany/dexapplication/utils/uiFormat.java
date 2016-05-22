package cl.mycompany.dexapplication.utils;

import java.util.StringTokenizer;

/**
 * Created by Matias on 5/21/2016.
 */
public class uiFormat {

    private static final String RED= "#ce6955";
    private static final String YELLOW = "#eae24e";
    private static final String GREEN = "#5dd15d";

    public static String numberToText(int number){
        String numberText;
        if(number <= 9)
            numberText = "00" + String.valueOf(number) + "|";
        else if(number <= 99)
            numberText = "0" + String.valueOf(number) + "|";
        else
            numberText = String.valueOf(number) + "|";

        return numberText;
    }

    public static String statColor(int baseStat){
        String color = "";
        if (baseStat <= 65)
            color = RED;
        else if (baseStat >65 && baseStat < 100)
            color = YELLOW;
        else
            color = GREEN;
        return color;
    }

    public static String deleteRL(String flavorText){
        StringTokenizer st = new StringTokenizer(flavorText,"\n");
        String completeLine = "";
        while (st.hasMoreTokens())
            completeLine += st.nextToken() + " ";
        return completeLine;
    }
}
