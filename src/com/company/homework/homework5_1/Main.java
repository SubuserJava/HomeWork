package com.company.homework.homework5_1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner consoleInput = new Scanner(System.in);
        System.out.println("Enter any text with smiles.");
        String stringFromConsole = consoleInput.nextLine();

        stringFromConsole = stringFromConsole.replaceAll("[a-zA-Zа-яА-Я]*", "");
        String[] stringFromConsoleArray = stringFromConsole.split(" ");

        for (int countArray = 0; countArray < stringFromConsoleArray.length; countArray++) {
            if (stringFromConsoleArray[0].matches("^[\\:\\;]?")) {
                System.out.println("Yes");
            }
        }
    }
}
