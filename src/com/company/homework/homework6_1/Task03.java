package com.company.homework.homework6_1;

import java.util.Arrays;
import java.util.Scanner;

public class Task03 {

    public static void main(String[] args) {

        Scanner consoleInput = new Scanner(System.in);
        System.out.println("Enter value of the number of elements in the array.");
        int numberStringInArr = consoleInput.nextInt();

        System.out.println("Beginning variant of String Array.");    // Начальный массив. Заполенение случайными словами и вывод в консоль.
        String[] stringArray = new String[numberStringInArr];
        System.arraycopy(getRandomStringArray(numberStringInArr), 0, stringArray, 0, stringArray.length);  // Копирование полученного "случайным" методом массива.
        System.out.println(Arrays.deepToString(stringArray) + "\n");

        printArrayToString(stringArray);                             // Вызов метода печати в строку, через пробел.
        System.out.println("\n");
        sortArrayReverse(stringArray);                               // Вызов метода сортировки в обратном порядке и вывод в консоль.
        System.out.println("\n");
        sortValueLetterInWords(stringArray);                         // Вызов метода
        System.out.println("\n");
    }

    private static String[] getRandomStringArray(int numberStringInArr) {                                 // Генерация случайных слов в массиве.
        String latinLettersString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String[] randomStringArray = new String[numberStringInArr];                                             // Создание массива длиной переданным значением кол-ва элементов.
        for (int countElementsArray = 0; countElementsArray < numberStringInArr; countElementsArray++) {  // Цикл - каждый элемент массива строк.
            StringBuilder randomString = new StringBuilder();
            for (int countCharWord = 0; countCharWord < (int) (Math.random() * 10) + 1; countCharWord++) {     // Цикл количеством шагов случайным размером слова от 1 до 10, чтобы без "пустых" слов.
                randomString.append(latinLettersString.charAt((int) (Math.random() * 50)));               // Заполенение слова случайными буквамилатиницы.
            }
            randomStringArray[countElementsArray] = randomString.toString();                                    // Полученное слово - в возвращаемый из метода массив.
        }
        return randomStringArray;
    }

    private static void printArrayToString(String[] stringArray) {
        System.out.print("Method of print string array with spaces.\nArray: " + String.join(" ", stringArray));
    }

    private static void sortArrayReverse(String[] stringArray) {
//        for (int countArr = 0; countArr < stringArray.length; countArr++) {   // Cтроки массива -> в нижний регистр.
//            stringArray[countArr] = stringArray[countArr].toLowerCase();
//        }
        Arrays.sort(stringArray);                                         // Сортировка массива.
        int count1 = 0;                                                   // "Переворачивание" массива, принцип подсмотрел в интернете.
        int count2 = stringArray.length - 1;
        String tempValue;
        while (count2 > count1) {                                         // "Бесконечный" цикл, зависимость от условия по значениям счётчика.
            tempValue = stringArray[count2];                              // "Перезапись" элементов массива.
            stringArray[count2] = stringArray[count1];
            stringArray[count1] = tempValue;
            count2--;
            count1++;
        }
        System.out.print("Sorting method 'reverse mode' (z -> a) without case-insensitively.\nArray: " + String.join(" ", stringArray));
    }

    private static void sortValueLetterInWords(String[] stringArray) {
        boolean isSorted = false;                                          // Метод "сортировки пузырьком", принцип подсмотрен в интренете.
        String tempVar;
        while (!isSorted) {
            isSorted = true;
            for (int countArr = 0; countArr < stringArray.length - 1; countArr++) {
                if (stringArray[countArr].length() > stringArray[countArr + 1].length()) {        // Сравниваются длины слов элементов массива
                    isSorted = false;

                    tempVar = stringArray[countArr];                                              // "Перезапись" элементов массива.
                    stringArray[countArr] = stringArray[countArr + 1];
                    stringArray[countArr + 1] = tempVar;
                }
            }
        }
        System.out.print("Sorting 'bubble-method' by length of words.\nArray: " + String.join(" ", stringArray));
    }
}
