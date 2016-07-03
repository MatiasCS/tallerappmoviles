package cl.mycompany.dexapplication.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
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
                    for(EvolvesTo_ secondEvo : secondEvoList){
                        evoChainList.add(secondEvo.getSpecies().getName());
                    }
            }
        }
    }

    public static List<int[]> getLevelUpmoves(List<Move> moveList){
        //Hashtable<Integer,Integer> levelUpMovesList = new Hashtable<>();
        List<int[]> levelUpMovesList;
        List<Integer> levelId = new ArrayList<Integer>();
        List<Integer> levelLearned = new ArrayList<Integer>();
        String gameVersion = "omega-ruby-alpha-sapphire";
        for(Move move : moveList){
            for(VersionGroupDetail groupDetail : move.getVersionGroupDetails()){
                if(groupDetail.getVersionGroup().getName().equals(gameVersion)){
                    if( groupDetail.getLevelLearnedAt() != 0){
                        levelId.add(supportFunctions.getIdFromURL(move.getMove().getUrl()));
                        levelLearned.add(groupDetail.getLevelLearnedAt());
                        //levelUpMovesList.put(supportFunctions.getIdFromURL(move.getMove().getUrl()),groupDetail.getLevelLearnedAt());
                    }
                }
            }
        }

        Integer [] copyLevelLearned = levelLearned.toArray(new Integer[0]);
        Arrays.sort(copyLevelLearned);
        levelUpMovesList = sortedList((Integer[]) levelId.toArray(new Integer[0]), (Integer[]) levelLearned.toArray(new Integer[0]), copyLevelLearned);
        return levelUpMovesList;
    }

    public static List<int[]> sortedList(Integer[] levelId, Integer[] levelLearned, Integer[]sortedLevelLearned){
        List<int[]> sortedList = new ArrayList<int[]>();
        int position = 0;
        for(int i = 0; i < levelId.length; i++){
            for(int j = 0; j < levelId.length; j++) {
                if(sortedLevelLearned[i].equals(levelLearned[j])){
                    position = j;
                    levelLearned[j] = -1;
                    break;
                }
            }
            int[] move = new int[] {levelId[position],sortedLevelLearned[i]};
            sortedList.add(move);
        }

        return sortedList;
    }
}
