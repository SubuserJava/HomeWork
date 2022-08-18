package com.company.homework.homework5_2;

import java.util.Arrays;
import java.util.Scanner;

public class Task07 {

    public static void main(String[] args) {

        Scanner consoleInput = new Scanner(System.in);
        System.out.print("Enter the dimension value of array: ");
        int dimArray = consoleInput.nextInt();
        int[] randomNumArray = new int[dimArray];
        System.out.print("Your array with random values from 3 to 13: \n[");
        for (int elementArr = 0; elementArr < randomNumArray.length; elementArr++) {
            randomNumArray[elementArr] = (int) (Math.random() * 11) + 3;               // Заполнение случайными числами от 3 до 13.
            System.out.print(randomNumArray[elementArr] + ",");
        }
        System.out.println("]");

        Arrays.sort(randomNumArray);
        int countMatch = 1;                      // Всё по аналогии с 5-м заданием
        int countPosition = 0;
        outer:
        do {
            if (randomNumArray[countPosition] == randomNumArray[countPosition + 1]) {
                while (randomNumArray[countPosition] == randomNumArray[countPosition + 1]) {
                    countMatch++;
                    countPosition++;
                    if (countPosition == randomNumArray.length - 1) {
                        System.out.println("Number " + randomNumArray[countPosition] + " repeats " + countMatch + " times.");
                        break outer;
                    }
                }
                System.out.println("Number " + randomNumArray[countPosition] + " repeats " + countMatch + " times.");
                countMatch = 1;
            } else {
                System.out.println("Number " + randomNumArray[countPosition] + " repeats 1 time.");
            }
            countPosition++;
        } while (countPosition != randomNumArray.length - 1);

        if (randomNumArray[randomNumArray.length - 1] != randomNumArray[randomNumArray.length - 2]) {
            System.out.println("Number " + randomNumArray[randomNumArray.length - 1] + " repeats 1 time.");
        }
    }
}



