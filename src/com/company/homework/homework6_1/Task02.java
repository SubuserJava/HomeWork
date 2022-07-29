package com.company.homework.homework6_1;

import java.util.Arrays;

public class Task02 {

    public static void main(String[] args) {


        printArray();                                                   // Массив тип int.
        printArray(1);                                 // 0 или единицу. Печтать веритикально или в строчку.
        printArray(4, 8, 1);  // Длина, значение элементов, вертикально или в строчку.
        printArray(5, 3.4f);       // Длина, значение элементов массива.
    }

    private static void printArray() {                               // Печать массива int без параметров.
        int[] integerArray = new int[7];
        Arrays.fill(integerArray, 101);

        System.out.println("One-dimensional array of integers without arguments.");
        for (int countArray : integerArray) {
            System.out.print(countArray + " ");
        }
        System.out.println();
    }

    private static void printArray(int printColumn) {                // Печатать массива строк вертикально или в строчку.
        String[] stringArray = {"abc", "def", "ghi"};
        if (printColumn == 1) {
            System.out.println("Print array vertical.");
            System.out.print(stringArray[0] + "\n");
            System.out.print(stringArray[1] + "\n");
            System.out.print(stringArray[2] + "\n");
        } else {
            System.out.println("Print array line again. " + Arrays.deepToString(stringArray));
        }
    }

    public static void printArray(int lengthMatrix, int valueElements, int toLineToVertical) {  // Печать двумерного массива с параметрами.
        int[][] twoDimMatrixArr = new int[lengthMatrix][lengthMatrix];
        System.out.println("Print two-dimensional matrix with received arguments. ");
        for (int countLines = 0; countLines < twoDimMatrixArr.length; countLines++) {
            for (int countColumn = 0; countColumn < twoDimMatrixArr.length; countColumn++) {
                twoDimMatrixArr[countLines][countColumn] = valueElements;       // Заполнение массива переданным значением.
                if (toLineToVertical == 1) {                                    // Проверка, вертикально или в строчку.
                    System.out.print(twoDimMatrixArr[countLines][countColumn] + " ");
                } else {
                    System.out.println(twoDimMatrixArr[countLines][countColumn] + " ");
                }
            }
            if (toLineToVertical == 1) {     // Проверка, вертикально или в строчку.
                System.out.print("");
            }
        }
        System.out.println();
    }

    public static void printArray(int lengthArray, float volElementsOfArray) {     // Метод создания и печати нулевой матрицы фиксированного размера.
        float[][] twoDimFloatMatrixArr = new float[lengthArray][lengthArray];
        System.out.println("Print two-dimensional float matrix. ");
        for (int countLines = 0; countLines < twoDimFloatMatrixArr.length; countLines++) {
            for (int countColumn = 0; countColumn < twoDimFloatMatrixArr.length; countColumn++) {
                twoDimFloatMatrixArr[countLines][countColumn] = volElementsOfArray;
                System.out.print(twoDimFloatMatrixArr[countLines][countColumn] + " ");
            }
        }
        System.out.println();
    }

}
