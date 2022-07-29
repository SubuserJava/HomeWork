package com.company.homework.homework6_1;

import java.util.Arrays;

public class Task01 {

    public static void main(String[] args) {

        int[][] matrixOneArr = new int[3][3];
        Arrays.fill(matrixOneArr, 3);

        int[][] matrixTwoArr = new int[3][3];
        Arrays.fill(matrixTwoArr, 2);

        int scalar = 3;
        System.out.println("Method identity matrix: " + Arrays.deepToString(getIdentityMatrix(4)));                                  // Единичная матрица.
        System.out.println("Method diagonal matrix: " + Arrays.deepToString(getDiagonalMatrix(5, 3)));                 // Диагональная матрица.
        System.out.println("Method null matrix: " + Arrays.deepToString(getNullMatrix(2)));                                          // Нулевая матрица.
        System.out.println("Method addiction two matrix: " + Arrays.deepToString(getAddictionMatrix(matrixOneArr, matrixTwoArr)));             // Сложение матриц
        System.out.println("Method multiplication two matrix: " + Arrays.deepToString(getMultiplicationMatrix(matrixOneArr, matrixTwoArr)));   // Умножение матриц
        System.out.println("Method multiplication two matrix: " + Arrays.deepToString(getMultiplicationMatrixByScalar(matrixOneArr, scalar))); // Умножение матрицы на скаляр.
        // Метода нахождения детерминанты пока нет, т.к. так не понял как его выполнить в коде. Понятен принцип Саррюса, но как это в код превратить...? Тупо копировать без понимания не хочу.
        printMatrix(matrixOneArr);                                                                                                             // Печать матрицы.
    }

    private static int[][] getIdentityMatrix(int valueMatrix) {                        // Метод создания единичной матрицы
        int[][] identityMatrixArr = new int[valueMatrix][valueMatrix];
        for (int rowColumn = 0; rowColumn < identityMatrixArr.length; rowColumn++) {
            identityMatrixArr[rowColumn][rowColumn] = 1;

        }
        return identityMatrixArr;
    }

    private static int[][] getDiagonalMatrix(int valueMatrix, int mainDiagNumber) {     // Метод создания диагональной матрицы.
        int[][] makeDiagonalMatrixArr = new int[valueMatrix][valueMatrix];
        for (int rowColumn = 0; rowColumn < makeDiagonalMatrixArr.length; rowColumn++) {
            makeDiagonalMatrixArr[rowColumn][rowColumn] = mainDiagNumber;
        }
        return makeDiagonalMatrixArr;
    }

    public static int[][] getNullMatrix(int valueMatrix) {                              // Метод создания нулевой мтарицы.
        return new int[valueMatrix][valueMatrix];
    }

    public static int[][] getAddictionMatrix(int[][] matrixOneArr, int[][] matrixTwoArr) {                      // Метод сложения матриц.
        int[][] addictionMatrixArr = new int[matrixOneArr.length][matrixTwoArr.length];
        for (int index1 = 0; index1 < matrixOneArr.length; index1++) {
            for (int index2 = 0; index2 < matrixOneArr.length; index2++) {
                addictionMatrixArr[index1][index2] = matrixOneArr[index1][index2] + matrixTwoArr[index1][index2];
            }
        }
        return addictionMatrixArr;
    }

    public static int[][] getMultiplicationMatrix(int[][] matrixOneArr, int[][] matrixTwoArr) {                 // Метод умножения матрицы на матрицу.
        int[][] multiMatrixArr = new int[matrixOneArr.length][matrixTwoArr.length];
        for (int countLine = 0; countLine < matrixOneArr.length; countLine++) {
            for (int countColumn = 0; countColumn < matrixOneArr.length; countColumn++) {
                multiMatrixArr[countLine][countColumn] = matrixOneArr[countLine][countColumn] * matrixTwoArr[countColumn][countLine];
            }
        }
        return multiMatrixArr;
    }

    public static int[][] getMultiplicationMatrixByScalar(int[][] matrixOneArr, int scalar) {             // Метод умножения матрицы на скаляр
        int[][] multByScalarArr = new int[matrixOneArr.length][matrixOneArr.length];
        for (int countLine = 0; countLine < matrixOneArr.length; countLine++) {
            for (int countColumn = 0; countColumn < matrixOneArr.length; countColumn++) {
                multByScalarArr[countLine][countColumn] = matrixOneArr[countLine][countColumn] * scalar;
            }
        }
        return multByScalarArr;
    }

    // Метода нахождения детерминанты матрицы пока нет, объяснил в начале. Тупо копировать из интернета без понимания не хочется.

    public static void printMatrix(int[][] matrixOneArr) {
        System.out.println("The Matrix one.");
        for (int countLines = 0; countLines < matrixOneArr.length; countLines++) {
            for (int countColumn = 0; countColumn < matrixOneArr.length; countColumn++) {
                System.out.print(matrixOneArr[countLines][countColumn] + " ");
            }
            System.out.println();
        }
    }
}
