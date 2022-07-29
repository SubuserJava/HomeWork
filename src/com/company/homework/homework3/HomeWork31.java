package com.company.homework.homework3;

public class HomeWork31 {                            // примеры разных арифметических действий с разными операторами.

    static final int MIN_NUM = 10;

    public static void main(String[] args) {

        int index = 0;
        int sumArray = 0;
        int calcResult1;
        int calcResult2;
        int calcResult3;

        int[] numArray = new int[4];
        for (int indexArray = 0; indexArray <= 3; indexArray++) { // Filling the massive 0 to 3
            numArray[indexArray] = indexArray;
            System.out.println(numArray[indexArray]);
            sumArray = numArray[indexArray] + sumArray;
        }

        System.out.println("Sum of the array elements is " + sumArray);

        System.out.println("Result of multiplying the first and last element of the array is " + (numArray[0] * numArray[3]));

        calcResult1 = numArray[1] - MIN_NUM + numArray[3];
        System.out.println("Element of the array [1] minus constant is " + calcResult1);

        calcResult2 = numArray[2] == 0 ? numArray[1] + numArray[2] : numArray[2] / numArray[3];
        System.out.println("Result of division is " + calcResult2);

        while (index < 4) {
            calcResult3 = numArray[index] - MIN_NUM;
            ++index;
            System.out.println("The result of division 10 " + calcResult3);
        }
    }
}