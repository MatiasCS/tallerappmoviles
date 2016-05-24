package cl.mycompany.dexapplication.utils;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import cl.mycompany.dexapplication.model.evolutionChainModel.Chain;
import cl.mycompany.dexapplication.model.evolutionChainModel.EvolvesTo;
import cl.mycompany.dexapplication.model.evolutionChainModel.EvolvesTo_;

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

    public static String[] getEvoList(Chain evoChain){
        List<String> evoChainList = new ArrayList<>();
        evoChainList.add(evoChain.getSpecies().getName());
        processEvolvesTo(evoChain.getEvolvesTo(),evoChainList);

        return evoChainList.toArray(new String[0]);

    }

    public static void processEvolvesTo(List<EvolvesTo> evolvesTo, List<String> evoChainList){
        if (evolvesTo != null) {
            for(EvolvesTo firsEvo : evolvesTo) {
                evoChainList.add(firsEvo.getSpecies().getName());
                List<EvolvesTo_> secondEvoList = evolvesTo.get(0).getEvolvesTo();
                if(secondEvoList != null)
                    for(EvolvesTo_ secondEvo : secondEvoList)
                        evoChainList.add(secondEvo.getSpecies().getName());
            }
        }
    }
}
