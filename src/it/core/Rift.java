package it.core;

import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Rift {
    private int[] rift;
    private String symbolInRift;


    public Rift(int size) {
        this.rift = new int[(size*size)];
    }

    public int[] getRift() {
        return rift;
    }
    public void setRift(int[] rift) {
        this.rift = rift;
    }

    public String getSymbolInRift() {
        return symbolInRift;
    }

    public void setSymbolInRift(String symbolInRift) {
        this.symbolInRift = symbolInRift;
    }

    @Override
    public String toString(){
        alphabetGenerator((int) Math.sqrt(rift.length));
        return IntStream.range(0, rift.length)
                .mapToObj(this::intToSymbol)
                .reduce("", String::concat);
    }

    public String intToSymbol(int position){
        int gridTotalSize = (int) Math.sqrt(rift.length);
        if(getRift()[position] == 0){
            symbolInRift = "\uD83C\uDF0A";
        } if(getRift()[position] == 1){
            symbolInRift = "\uD83D\uDEA2";
        } if(getRift()[position] == 2){
            symbolInRift = "\uD83D\uDD25";
        }

        String symbol = String.format("| %s ", symbolInRift);
        if (position%gridTotalSize == 0){
            symbol = String.format("| %s | %s ",position/gridTotalSize+1, symbolInRift);
        }
        if (position > 0 && position % gridTotalSize == (gridTotalSize - 1)) {
            symbol += "|\n";
        }
        return symbol;
        
    }

    public void alphabetGenerator(int size){
            String finalAlphabet = "| X ";
            String finalAlphabetLetters = (IntStream.range('A',size+'A')
                    .mapToObj(Character::toString)
                    .collect(Collectors.joining(" |  ", " | ", "  |")));

        System.out.println(finalAlphabet.concat(finalAlphabetLetters));
    }


    //          -- --  GRIGLIA DI BOOLEANS -- --

//    public String printGridBoolean(boolean[] grid){
//        return IntStream.range(0, grid.length)
//                .mapToObj(i -> printGridBooleanHelper(i, grid[i]))
//                .reduce("", String::concat);
//    }
//
//    public String printGridBooleanHelper(int position, boolean value){
//        int gridTotalSize = (int) Math.sqrt(rift.length);
//        int counter = 1;
//
//        String xOro = getRift()[position] == 0 ? "true" : "false";
//        String symbol = String.format("| %s ", xOro);
//        if (position%gridTotalSize == 0){
//            symbol = String.format("| %s | %s ",position/gridTotalSize+1,xOro);
//        }
//        if (position > 0 && position % gridTotalSize == (gridTotalSize - 1)) {
//            symbol += "|\n";
//        }
//        return symbol;
//
//    }
}



