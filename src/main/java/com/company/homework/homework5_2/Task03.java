package com.company.homework.homework5_2;

public class Task03 {

    public static void main(String[] args) {

        int[] anyArray = {11, 11, 11, 11, 11, 11};

        for (int countElements = 0; countElements < anyArray.length; countElements++) {
            if (anyArray[0] == anyArray[countElements]) {
            } else {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes"); // yes
    }
}
