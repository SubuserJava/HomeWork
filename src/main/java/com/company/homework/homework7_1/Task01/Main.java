package com.company.homework.homework7_1.Task01;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner consoleInput = new Scanner(System.in);
        System.out.println("Enter ranges separated by commas. Example: 2 8, 6 15, 9 12");
        String inputConsole = consoleInput.nextLine();
        String[] rangeString = inputConsole.split(",");
        Range[] rangeArray = new Range[rangeString.length];

        fillRangArrayByRangeString(rangeString, rangeArray);

        for (Range range : rangeArray) {
            if ((range.endPoint - range.startPoint) < 0) {
                System.out.println("Error! End point " + range.endPoint + " < then start point " + range.startPoint + ", and range has a negative value.");
            } else {
                System.out.println("Range: " + getRangeLength(range.startPoint, range.endPoint));
            }
        }
    }

    private static int getRangeLength(int startPoint, int endPoint) {
        return endPoint - startPoint;
    }

    private static void fillRangArrayByRangeString(String[] rangeString, Range[] rangeArray) {
        for (int i = 0; i < rangeArray.length; i++) {
            String trimString = rangeString[i].trim();
            String[] point = trimString.split(" ");
            Range range = new Range(Integer.parseInt(point[0]), Integer.parseInt(point[1]));
            rangeArray[i] = range;
        }
    }


}
