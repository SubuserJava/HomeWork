package com.company.homework.homework5_1;

import java.util.Scanner;

public class Task12 {

    public static void main(String[] args) {

        Scanner consoleInput = new Scanner(System.in);
        System.out.println("Enter any text with smiles.");
        String stringFromConsole = consoleInput.nextLine();

        stringFromConsole = stringFromConsole.replaceAll("[a-zA-Zа-яА-Я]*", "");
        String[] stringFromConsoleArray = stringFromConsole.trim().split(" ") ;

        int countSmiles = 0;
        for (String arrayElement : stringFromConsoleArray) {
            if (arrayElement.matches("^[:;]-*((\\[)|(\\])|(\\()|(\\)))+")) {
                countSmiles++;
            }
        }
        System.out.println("Values smails is " + countSmiles);
    }
}
