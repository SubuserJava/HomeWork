package com.company.homework.homework5_2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task08 {

    public static void main(String[] args) {

        Scanner consoleInput = new Scanner(System.in);
        System.out.print("Enter the dimension value of array: ");
        int dimArray = consoleInput.nextInt();
        char[] randomCharArray = new char[dimArray];
        System.out.print("Your array with random lowercase latin letters: \n[");
        Random r = new Random();
        for (int elementArr = 0; elementArr < randomCharArray.length; elementArr++) {
            randomCharArray[elementArr] = (char) (r.nextInt(25) + 97);               // Заполнение случайными символами a-z.
            System.out.print(randomCharArray[elementArr] + ",");
        }
        System.out.println("]");

        Arrays.sort(randomCharArray);
        int countMatch = 1;                                                          // Всё по аналогии с 5-м заданием
        int countPosition = 0;
        outer:
        do {
            if (randomCharArray[countPosition] == randomCharArray[countPosition + 1]) {
                while (randomCharArray[countPosition] == randomCharArray[countPosition + 1]) {
                    countMatch++;
                    countPosition++;
                    if (countPosition == randomCharArray.length - 1) {
                        break outer;
                    }
                }
                if (countMatch > 3) {
                    System.out.println("Character " + randomCharArray[countPosition] + " repeats more when 3 times.");
                }
                countMatch = 1;
            }
            countPosition++;
        } while (countPosition != randomCharArray.length - 1);
    }
}
