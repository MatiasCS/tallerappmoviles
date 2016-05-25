package cl.mycompany.dexapplication.utils;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

import cl.mycompany.dexapplication.model.Pokemon;
import cl.mycompany.dexapplication.model.evolutionChainModel.Chain;
import cl.mycompany.dexapplication.model.evolutionChainModel.EvolvesTo;
import cl.mycompany.dexapplication.model.evolutionChainModel.EvolvesTo_;
import cl.mycompany.dexapplication.model.pokemonModel.Move;
import cl.mycompany.dexapplication.model.pokemonModel.VersionGroupDetail;

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

    public static Hashtable<Integer, Integer> getLevelUpmoves(List<Move> moveList){
        Hashtable<Integer,Integer> levelUpMovesList = new Hashtable<>();
        String gameVersion = "omega-ruby-alpha-sapphire";
        for(Move move : moveList){
            for(VersionGroupDetail groupDetail : move.getVersionGroupDetails()){
                if(groupDetail.getVersionGroup().getName().equals(gameVersion)){
                    if( groupDetail.getLevelLearnedAt() != 0)
                        levelUpMovesList.put(supportFunctions.getIdFromURL(move.getMove().getUrl()),groupDetail.getLevelLearnedAt());
                }
            }
        }
        return levelUpMovesList;
    }

    public static void sortValue(Hashtable<?, Integer> t){

        //Transfer as List and sort it
        ArrayList<Map.Entry<?, Integer>> l = new ArrayList(t.entrySet());
        Collections.sort(l, new Comparator<Map.Entry<?, Integer>>() {

            public int compare(Map.Entry<?, Integer> o1, Map.Entry<?, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
    }
}
