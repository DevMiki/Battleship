package it.core;

import java.io.IOException;
import java.util.List;

import static it.console.Console.*;

public class GameStarter {

    public static void main(String[] args) {
        Rift summonersRift;
        int size;

        try {

            System.out.println("Da quanto vuoi la griglia? ");
            size = intReader();
            //Creo il costruttore
            summonersRift = new Rift(size);
//            Creo la linea sopra con le lettere
//            summonersRift.alphabetGenerator(size);
//            Creo la parte rimanente della griglia
            String gridRift = summonersRift.toString();
            System.out.println(gridRift);
            System.out.println("Puoi scegliere fino a 3 navi, quante ne vuoi?" );
            int numOfShips = intReader();
            List<List<String>> a = RiftPopulator.placeShips(summonersRift,numOfShips);

            CheckGuess.checkGuess(a, RiftPopulator.coordsCells, summonersRift);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
