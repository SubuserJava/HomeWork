package com.company.homework.homework5_2;

import java.util.Arrays;

public class Task02 {

    public static void main(String[] args) {

        double[] randomNumArray = new double[30];
        for (int countArr = 0; countArr < 30; countArr++) {
            randomNumArray[countArr] = Math.random() * 121 - 70;  // Заполнение массива.
        }
        Arrays.sort(randomNumArray);                              // Сортировка.
        System.out.println("Min value from array is " + randomNumArray[0]);
        System.out.println("Max value from array is " + randomNumArray[29]);
    }
}
