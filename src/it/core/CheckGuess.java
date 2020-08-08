package it.core;

import it.playersEnum.HitOccurency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static it.console.Console.lineReader;
import static it.playersEnum.HitOccurency.*;

public class CheckGuess {
    static String message;
    static int numOfMiss = 0;
    static int hit = 0;


    public static void checkGuess(List<List<String>> alphaCells, List<List<Integer>> coordsCells, Rift summonerRift) {
        List<String> flatAlphaCells = alphaCells.stream().flatMap(Collection::stream).collect(Collectors.toList());
        List<String> flatAlphaCellsChoices = alphaCells.stream().flatMap(Collection::stream).collect(Collectors.toList());


        while (flatAlphaCells.size() > 0) {
            hit = 0;
            System.out.println("Spara un colpo: ");
            String userGuess = lineReader();
            String replaceUserGuess = userGuess.replace(userGuess.charAt(0),Character.toUpperCase(userGuess.charAt(0)));
            for (int x = 0; x < alphaCells.size(); x++) {

                for (int j = 0; j < alphaCells.get(x).size(); j++) {
                    if (alphaCells.get(x).get(j).equals(replaceUserGuess)) {
                        alphaCells.get(x).remove(replaceUserGuess);
                        flatAlphaCells.remove(replaceUserGuess);
                        summonerRift.getRift()[coordsCells.get(x).get(j)-1] = 2;
                        coordsCells.get(x).remove(j);
                        if(alphaCells.get(x).isEmpty()){
                            System.out.println("HAI DISTRUTTO LA NAVE N°"+ (x+1));
                            hit = 5;
                            break;
                        }
                        message = NAVE_COLPITA.getMessage();
                        hit++;
                        break;
                    }

                }
            }
            if(!flatAlphaCellsChoices.contains(replaceUserGuess) && numOfMiss > 0){
                message = ACQUA_RICOLPITA.getMessage();
                numOfMiss++;
            }
            if(!(flatAlphaCellsChoices.contains(replaceUserGuess)) && numOfMiss == 0){
                message = ACQUA_COLPITA.getMessage();
                numOfMiss++;
            }
            if (flatAlphaCellsChoices.contains(replaceUserGuess)){
                message = NAVE_RICOLPITA.getMessage();
            }
            if (flatAlphaCellsChoices.contains(replaceUserGuess) && hit == 1){
                message = NAVE_COLPITA.getMessage();
                hit++;
            }
            if (hit >= 5){
                message = "";
            }
            System.out.println(message);
            System.out.println(summonerRift.toString());
        }
        System.out.println(NAVE_AFFONDATA.getMessage());
        System.out.println("NO WAY YOU WIN!");
    }


}
