package it.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Console {

    public static String lineReader() {
        String lineRead = "";
        try {
            BufferedReader toRead = new BufferedReader(new InputStreamReader(System.in));
            lineRead = toRead.readLine();
        } catch (IOException e) {
            System.out.println("porcatroia samir");
        }
        return lineRead;
    }

    public static String lineReaderScanner() {
        String lineRead = "";
        Scanner toRead = new Scanner(System.in);
        lineRead = toRead.nextLine();
        return lineRead;
    }

    public static int intReader() throws IOException {
        int intRead = 0;
         BufferedReader intToRead = new BufferedReader(new InputStreamReader(System.in));
         return intRead = Integer.parseInt(intToRead.readLine());
    }

}
