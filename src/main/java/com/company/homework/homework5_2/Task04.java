package com.company.homework.homework5_2;

import java.util.Arrays;

public class Task04 {

    public static void main(String[] args) {

        int[] anyArray = {11, 13, 12, 16, 15, 14};
        Arrays.sort(anyArray);

        for (int countElements = 0; countElements < anyArray.length - 1; countElements++) {
            if (anyArray[countElements] == anyArray[countElements + 1]) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
