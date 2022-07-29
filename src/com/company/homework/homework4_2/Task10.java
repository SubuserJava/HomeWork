package com.company.homework.homework4_2;

import java.util.Arrays;

public class Task10 {

    private static String[][] NUM_ZERO = {
            {" ", " ", "0", "0", "0", " ", " "},
            {" ", "0", " ", " ", " ", "0", " "},
            {"0", " ", " ", " ", " ", " ", "0"},
            {"0", " ", " ", " ", " ", " ", "0"},
            {"0", " ", " ", " ", " ", " ", "0"},
            {" ", "0", " ", " ", " ", "0", " "},
            {" ", " ", "0", "0", "0", " ", " "},
    };
    private static String[][] NUM_ONE = {
            {" ", " ", " ", "1", " ", " ", " "},
            {" ", " ", "1", "1", " ", " ", " "},
            {" ", "1", " ", "1", " ", " ", " "},
            {" ", " ", " ", "1", " ", " ", " "},
            {" ", " ", " ", "1", " ", " ", " "},
            {" ", " ", " ", "1", " ", " ", " "},
            {" ", " ", "1", "1", "1", " ", " "},
    };
    private static String[][] numTwo = {
            {" ", " ", "2", "2", "2", " ", " "},
            {" ", "2", " ", " ", " ", "2", " "},
            {" ", "2", " ", " ", "2", " ", " "},
            {" ", " ", " ", "2", " ", " ", " "},
            {" ", " ", "2", " ", " ", " ", " "},
            {" ", "2", " ", " ", " ", " ", " "},
            {" ", "2", "2", "2", "2", "2", " "},
    };
    private static String[][] NUM_THREE = {
            {" ", " ", "3", "3", "3", " ", " "},
            {" ", "3", " ", " ", " ", "3", " "},
            {" ", " ", " ", " ", " ", "3", " "},
            {" ", " ", " ", "3", "3", " ", " "},
            {" ", " ", " ", " ", " ", "3", " "},
            {" ", "3", " ", " ", " ", "3", " "},
            {" ", " ", "3", "3", "3", " ", " "},
    };
    private static String[][] NUM_FOUR = {
            {" ", " ", " ", " ", "4", " ", " "},
            {" ", " ", " ", "4", "4", " ", " "},
            {" ", " ", "4", " ", "4", " ", " "},
            {" ", "4", " ", " ", "4", " ", " "},
            {" ", "4", "4", "4", "4", "4", "4"},
            {" ", " ", " ", " ", "4", " ", " "},
            {" ", " ", " ", " ", "4", " ", " "},
    };
    private static String[][] NUM_FIVE = {
            {" ", "5", "5", "5", "5", " ", " "},
            {" ", "5", " ", " ", " ", " ", " "},
            {" ", "5", " ", " ", " ", " ", " "},
            {" ", "5", "5", "5", "5", " ", " "},
            {" ", " ", " ", " ", " ", "5", " "},
            {" ", "5", " ", " ", " ", "5", " "},
            {" ", " ", "5", "5", "5", " ", " "},
    };
    private static String[][] NUM_SIX = {
            {" ", " ", "6", "6", "6", " ", " "},
            {" ", "6", " ", " ", " ", " ", " "},
            {" ", "6", " ", " ", " ", " ", " "},
            {" ", "6", "6", "6", "6", " ", " "},
            {" ", "6", " ", " ", " ", "6", " "},
            {" ", "6", " ", " ", " ", "6", " "},
            {" ", " ", "6", "6", "6", " ", " "},
    };
    private static String[][] NUM_SEVEN = {
            {" ", "7", "7", "7", "7", "7", " "},
            {" ", " ", " ", " ", " ", "7", " "},
            {" ", " ", " ", " ", "7", " ", " "},
            {" ", " ", " ", "7", " ", " ", " "},
            {" ", " ", "7", " ", " ", " ", " "},
            {" ", "7", " ", " ", " ", " ", " "},
            {" ", "7", " ", " ", " ", " ", " "},
    };
    private static String[][] NUM_EIGHT = {
            {" ", " ", "8", "8", "8", " ", " "},
            {" ", "8", " ", " ", " ", "8", " "},
            {" ", "8", " ", " ", " ", "8", " "},
            {" ", " ", "8", "8", "8", " ", " "},
            {" ", "8", " ", " ", " ", "8", " "},
            {" ", "8", " ", " ", " ", "8", " "},
            {" ", " ", "8", "8", "8", " ", " "},
    };
    private static String[][] NUM_NINE = {
            {" ", " ", "9", "9", "9", " ", " "},
            {" ", "9", " ", " ", " ", "9", " "},
            {" ", "9", " ", " ", " ", "9", " "},
            {" ", " ", "9", "9", "9", "9", " "},
            {" ", " ", " ", " ", " ", "9", " "},
            {" ", " ", " ", " ", " ", "9", " "},
            {" ", " ", "9", "9", "9", " ", " "},
    };

    public static void main(String[] args) {

        String inputNumber = "01";



        int printArrayLength = inputNumber.length() * 7;
        String[][] printArray = new String[printArrayLength][];

        String a = "NUM_ZERO";
        String b = "NUM_ONE";

        String[] c = {"NUM_ZERO", "NUM_ONE"};
        String d = c[0];
        System.out.println(d);

        System.arraycopy(NUM_ZERO, 0, printArray, 0, 7);
        System.arraycopy(NUM_ONE, 0, printArray, 7, 7);

        for (int arrayCountLines = 0; arrayCountLines < printArray[0].length; arrayCountLines++) {
            for (int countPrintLines = arrayCountLines; countPrintLines < printArray.length; countPrintLines += 7) {
                System.out.print(Arrays.deepToString(printArray[countPrintLines]).replaceAll("\\[|\\]|\\,\\s", ""));
            }
            System.out.println();


//            for (int a = 0; a < numEight.length; a++) {
//            System.out.println(Arrays.deepToString(numEight[a]).replaceAll("\\[|\\]|\\,\\s", ""));
//        }

        }
    }

    private static void totalPrintArray (int printArray) {

    }
}

