package it.core;

import it.playersEnum.ShipType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RiftPopulator {

    static List<List<Integer>> coordsCells;

    public static List<List<String>> placeShips(Rift shipRift, int shipsToPlace) {
        //Questo mi torna tutti i valori dell'enum in un array
        ShipType[] shipTypes = ShipType.values();
        //Aggiungo tanti array quante saranno le navi scelte all'inizio in GameStarter
        List<List<String>> alphaCells = IntStream.range(0,shipsToPlace).
                mapToObj(k -> new ArrayList<String>()).
                collect(Collectors.toList());
        //Una lista di arrayList grande quanto le navi da piazzare
        coordsCells = IntStream.range(0,shipsToPlace).
                mapToObj(k -> new ArrayList<Integer>()).
                collect(Collectors.toList());


        int shipCounter = 0;
        for (int i = 0; i < shipsToPlace; i++) {
            //Scelgo una nave casuale nell'array di enum
            String shipName = shipTypes[(int) (Math.random()*(shipTypes.length))].name();
            int shipSize = shipName.length();
            //Creo una stringa lunga fino alla lunghezza scelta della griglia
            String alphabet = IntStream.range('A', 'A' + ((int) Math.sqrt(shipRift.getRift().length))).mapToObj(Character::toString).collect(Collectors.joining());
            //Miscellaneous
            String temp = null;
            int[] coords = new int[shipSize];
            int attempts = 0;
            boolean success = false;
            int spawnLocation;
            int incr = 1;
            shipCounter++;



            while (!success && attempts++ < 300) {
                if ((shipCounter % 2) == 1) {
                    incr = (int) Math.sqrt(shipRift.getRift().length);
                }

                spawnLocation = (int) (Math.random() * (shipRift.getRift().length));
                //variabile che mi serve per capire quando fermarmi una volta che sarà uguale alla length summoner
                int x = 0;
                //lo metto true per il prossimo while
                success = true;
                while (success && x < shipSize) {
                    //Perchè in origine ho sotto una griglia di int
                    if ((shipRift.getRift()[spawnLocation] == 0)) {
                        //aggiungo al mio array di interi grande quanto il nome della nave la coordinata e poi x++
                        coords[x++] = spawnLocation;
                        //provo la posizione adiacente
                        spawnLocation += incr;
                        if (spawnLocation >= shipRift.getRift().length) {
                            success = false;
                        }
                        //evito l'effetto pacman (metti che stava in 4, cresce di 1, ma la seconda condizione fa zero, significa che è nella prima colonna, è andata a capo
                        if (incr == 1 && (spawnLocation % Math.sqrt(shipRift.getRift().length) == 0)) {
                            success = false;
                        }
                    } else {
//                        System.out.println("Already used location: " + spawnLocation);
                        success = false;
                    }
                }
            }
            //Turn location in alphacoords
            int x = 0;
            int row = 0;
            int column = 0;

            while (x < shipSize) {
                //cambio la griglia di interi di partenza così poi mi stamperà il simbolo della nave invece che dell'onda
                shipRift.getRift()[coords[x]] = 1;
                //+1 perchè farebbe la linea 0 ma in battaglia navale si parte da 1
                row = (coords[x] / ((int) Math.sqrt(shipRift.getRift().length))) + 1;
                column = coords[x] % ((int) Math.sqrt(shipRift.getRift().length));
                coordsCells.get(i).add(coords[x]+1);
                //piglio la lettera corrispondente alla colonna
                temp = String.valueOf(alphabet.charAt(column));
                //sparo i valori dentro il primo arraylist in alphaCells
                alphaCells.get(i).add(temp.concat(Integer.toString(row)));
                x++;
            }
        }
        System.out.println(shipRift.toString());
        //Se mettevo solo .values() mi venivano fuori stampati con l'array
        System.out.println("Le navi che ti potevano spuntare rientrano tra queste: "+ Stream.of(ShipType.values()).map(ShipType::name).collect(Collectors.joining(", ")));
        IntStream.range(0,shipsToPlace).forEach(i->System.out.print("coordinate nave n°" + (i + 1)+ ": "+ String.join(",", alphaCells.get(i))+ "\n"));
//        System.out.println("Le coordinate come numeri invece sono queste: ");
//        coordsCells.forEach(System.out::println);
        return alphaCells;
    }


}
