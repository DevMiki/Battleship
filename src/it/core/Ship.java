package it.core;

import it.playersEnum.ShipType;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ship {
    String name = getRandomSummoner();

    public String getName() {
        return name;
    }

    public String getRandomSummoner(){
        ShipType[] shipTypes = ShipType.values();
        return shipTypes[(int) (Math.random()*(shipTypes.length))].name();
    }

    public List<Ship> getArmy(int army){
        return Stream.generate(new Supply()).limit(army).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Summoner{" +
                "name='" + name + '\'' +
                '}';
    }
}
