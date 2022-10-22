package com.company.homework.homework5_1;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;

public class Task09 {

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setOut(new PrintStream(System.out, true, "UTF-8"));

        Scanner consoleInput = new Scanner(System.in);
        System.out.println("Enter first sentence supposed anagram.");
        String firstSentence = consoleInput.nextLine();
        System.out.println("Enter second sentence supposed anagram.");
        String secondSentence = consoleInput.nextLine();

        if (prepareString(firstSentence).equals(prepareString(secondSentence))) {   // Вызов методов и сравнение отсортированных массивов.
            System.out.println("First sentence is anagram to second sentence.");
        } else {
            System.out.println("No. Not anagram.");
        }
    }

    private static String prepareString(String stringSentence) {
        stringSentence = stringSentence.toLowerCase().trim().replaceAll("[\\s+]", "");  // Строку в нижний регистр, убирание пробелов (начальных и между словами).
        char[] charArrFirst = stringSentence.toCharArray();                 // Строку - в массив.
        Arrays.sort(charArrFirst);                                     // Сортировка массива.
        return new String(charArrFirst);
    }

    private static String prepareSecondString(String secondSentence) {   // Аналогично, как с первым предложением.
        secondSentence = secondSentence.toLowerCase().trim().replaceAll("\\s+", "");
        char[] charArrSecond = secondSentence.toCharArray();
        Arrays.sort(charArrSecond);
        return new String(charArrSecond);
    }
}


