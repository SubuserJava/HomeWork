package com.company.homework.homework6_1;

import java.util.Arrays;

public class Task04 {

    public static void main(String[] args) {

        int linesMatrix = 4;
        String[][] matrixArray = new String[linesMatrix][linesMatrix * 2 - 1];

        for (int a = 0; a < matrixArray.length; a++) {        // Заполнение массива пробелами.
            for (int b = 0; b < linesMatrix * 2 - 1; b++) {
                matrixArray[a][b] = " ";
            }
        }
        System.out.println(Arrays.deepToString(matrixArray));


//        int columns = (matrixArray.length * 2 - 1) / 2;  // 3

        for (int countLines = 0, columns = 3; countLines < matrixArray.length; countLines++, columns--) {

            for (int countStep = 0; countStep <= countLines; countStep++) {

                matrixArray[countLines][columns] = "-";

               }


            }



        }

//             int centerLinesMatrix = linesMatrix + 1;
//
//        for (int countLines = 0; countLines < linesMatrix; countLines++) {                    // Цикл линий.
//            for (int countColumns = 0; countColumns < linesMatrix * 2 - 1; countColumns++) {  // Цикл столбцов.
//
//
//            }
//
//        }

    }

