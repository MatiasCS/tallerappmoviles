package cl.mycompany.dexapplication.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import cl.mycompany.dexapplication.R;
import cl.mycompany.dexapplication.model.evolutionChainModel.Chain;
import cl.mycompany.dexapplication.model.evolutionChainModel.EvolvesTo;
import cl.mycompany.dexapplication.model.typeModel.DamageRelations;
import cl.mycompany.dexapplication.model.typeModel.DoubleDamageFrom;
import cl.mycompany.dexapplication.model.typeModel.DoubleDamageTo;
import cl.mycompany.dexapplication.model.typeModel.HalfDamageFrom;
import cl.mycompany.dexapplication.model.typeModel.HalfDamageTo;
import cl.mycompany.dexapplication.model.typeModel.NoDamageFrom;
import cl.mycompany.dexapplication.model.typeModel.NoDamageTo;

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

    public static Map<String ,String> timesEffectiveFromMonoTyping(List<DoubleDamageFrom> times2, List<HalfDamageFrom> timesHalf,
                                                                        List<NoDamageFrom> times0){
        Map <String, String> weaknesses = new Hashtable<String,String>();

        for(DoubleDamageFrom type : times2)
            weaknesses.put(type.getName(),"X2");

        for(HalfDamageFrom type : timesHalf)
            weaknesses.put(type.getName(),"X1/2");

        for(NoDamageFrom type: times0)
            weaknesses.put(type.getName(),"X0");

        return weaknesses;
    }

    public static Map<String ,String> timesEffectiveTo(List<DoubleDamageTo> times2, List<HalfDamageTo> timesHalf,
                                                                   List<NoDamageTo> times0){
        Map <String, String> weaknesses = new Hashtable<String,String>();

        for(DoubleDamageTo type : times2)
            weaknesses.put(type.getName(),"X2");

        for(HalfDamageTo type : timesHalf)
            weaknesses.put(type.getName(),"X1/2");

        for(NoDamageTo type: times0)
            weaknesses.put(type.getName(),"X0");

        return weaknesses;
    }

    public static Map<String ,String> timesEffectiveFromDualTyping(List<List<DoubleDamageFrom>> times2, List<List<HalfDamageFrom>> timesHalf,
                                                                   List<List<NoDamageFrom>> times0){
        Map <String, String> weaknesses = new Hashtable<String,String>();
        List<DoubleDamageFrom> type1Times2 = times2.get(0);
        List<DoubleDamageFrom> type2Times2 = times2.get(1);
        List<HalfDamageFrom> type1TimesHalf = timesHalf.get(0);
        List<HalfDamageFrom> type2TimesHalf = timesHalf.get(1);
        List<NoDamageFrom> type1Times0 = times0.get(0);
        List<NoDamageFrom> type2Times0 = times0.get(1);

        for(DoubleDamageFrom type : type1Times2){
            String effectiveness  = timesEffectiveFromDouble(type.getName(), type2Times2, type2TimesHalf);
            weaknesses.put(type.getName(),effectiveness);
        }
        for (DoubleDamageFrom type: type2Times2){
            if(!weaknesses.containsKey(type.getName())){
                String effectiveness  = timesEffectiveFromDouble(type.getName(), type1Times2, type1TimesHalf);
                weaknesses.put(type.getName(),effectiveness);
            }
        }

        for(HalfDamageFrom type : type1TimesHalf){
            String effectiveness  = timesEffectiveFromHalf(type.getName(), type2Times2, type2TimesHalf);
            weaknesses.put(type.getName(),effectiveness);
        }

        for (HalfDamageFrom type: type2TimesHalf){
            if(!weaknesses.containsKey(type.getName())){
                String effectiveness  = timesEffectiveFromHalf(type.getName(), type1Times2, type1TimesHalf);
                weaknesses.put(type.getName(),effectiveness);
            }
        }

        for(NoDamageFrom type: type1Times0)
            weaknesses.put(type.getName(),"x0");

        for (NoDamageFrom type: type2Times0){
            weaknesses.put(type.getName(),"x0");
        }

        return weaknesses;
    }

    public static String timesEffectiveFromHalf(String type, List<DoubleDamageFrom> times2, List<HalfDamageFrom> timesHalf){
        String effectiveness = "x1/2";

        for (DoubleDamageFrom iterator: times2)
            if(iterator.getName().equals(type))
                effectiveness = "x1";

        for (HalfDamageFrom iterator: timesHalf)
            if(iterator.getName().equals(type))
                effectiveness = "x1/4";

        return effectiveness;
    }

    public static String timesEffectiveFromDouble(String type, List<DoubleDamageFrom> times2, List<HalfDamageFrom> timesHalf){
        String effectiveness = "x2";

        for (DoubleDamageFrom iterator: times2)
            if(iterator.getName().equals(type))
                effectiveness = "x4";

        for (HalfDamageFrom iterator: timesHalf)
            if(iterator.getName().equals(type))
                effectiveness = "x1";

        return effectiveness;
    }

    public static void setText(View v, Resources r, Map<String, String> weaknesses){
        String textValue = "";
        String  tvID;
        TextView tv_type;
        for(Map.Entry<String,String> w : weaknesses.entrySet()){
            tvID = "tv_";
            tvID += w.getKey();
            textValue = w.getKey().toUpperCase() + " " + w.getValue();
            int identifier = r.getIdentifier(tvID,"id","cl.mycompany.dexapplication");
            tv_type = (TextView) v.findViewById(identifier);
            tv_type.setText(textValue);
        }
    }
}
