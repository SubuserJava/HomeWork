package com.company.homework.homework7_1.Task02;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner consoleInput = new Scanner(System.in);
        System.out.println("Enter ranges separated by commas. Example: 9 12, 2 8, 6 15, ");
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
        System.out.println();

        checkRange(rangeArray);
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

    private static void checkRange(Range[] rangeArray) {                      // По аналогии с первым заданием, только добавился этот метод проверки диапазонов на пересекаемость.
        Scanner consoleInput = new Scanner(System.in);                        // Диапазоны для проверки выбираются из массива диапазонов.
        System.out.print("Enter numbers range from your string of ranges for checking crossing.\nRange one: ");
        int numOfRangeOne = consoleInput.nextInt();
        System.out.print("Range two: ");
        int numOfRangeTwo = consoleInput.nextInt();
        if (numOfRangeOne == 0 | numOfRangeTwo == 0) {
            System.out.println("Error! You entered zero value of number.");
        } else {
            if ((rangeArray[numOfRangeOne - 1].endPoint >= rangeArray[numOfRangeTwo - 1].startPoint) |
                    (rangeArray[numOfRangeOne - 1].startPoint <= rangeArray[numOfRangeTwo - 1].endPoint)) {
                System.out.println("Ranges crossing");
            } else {
                System.out.println("Ranges not crossing.");
            }
        }
    }
}
