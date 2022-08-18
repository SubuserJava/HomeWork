package com.company.homework.homework6_1;

import java.util.Scanner;

public class Task06 {

    public static void main(String[] args) {

        Scanner consoleInput = new Scanner(System.in);
        System.out.println("Enter value of the number of elements in the array.");
        String inputFromConsole = consoleInput.nextLine();
        checkSymbolsMethod(inputFromConsole);
    }

    private static void checkSymbolsMethod(String inputFromConsole) {

        inputFromConsole = inputFromConsole.replaceAll("[^\\(\\)\\[\\]]", "");

        int countOpenBracket = 0;          // Счётчик (
        int countCloseBracket = 0;         // Счётчик )
        int countOpenSquareBracket = 0;    // Счётчик [
        int countCloseSquareBracket = 0;   // Счётчик ]
        for (int index = 0; index < inputFromConsole.length(); index++) {
            if (index == '(') {
                countOpenBracket++;
            } else if (index == ')') {
                countCloseBracket++;
            } else if (index == '[') {
                countOpenSquareBracket++;
            } else if (index == ']') {
                countCloseSquareBracket++;
            }
        }
    }
}
