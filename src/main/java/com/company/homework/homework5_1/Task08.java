package com.company.homework.homework5_1;

import java.util.Scanner;

public class Task08 {

    public static void main(String[] args) {

        Scanner consoleInput = new Scanner(System.in);                   // Ввод имени переменной без дополнительных проверок.
        System.out.print("Enter variable id - ");
        String inputFromConsole = consoleInput.nextLine();

        if (getCheckTypeOfString(inputFromConsole).equals("MixType")) {                   // Вызов методов завимости от результатов сравнений.
            System.out.println("This type of variable name is mixed type.");
        } else if (getCheckTypeOfString(inputFromConsole).equals("Java")) {
            System.out.print("This type of variable name is Java style.\n" +
                    "The same name of variable in C++ style: " + getChangeStringToCStyle(inputFromConsole));
        } else if (getCheckTypeOfString(inputFromConsole).equals("C++")) {
            System.out.println("This type of variable name is C++ style.\n" +
                    "The same name of variable in C style: " + getChangeStringToJavaStyle(inputFromConsole));
        }
    }

    private static String getCheckTypeOfString(String inputFromConsole) {            // Метод выявления типа стиля имени переменной

        char[] charsArrayFromInputString = inputFromConsole.toCharArray();           // В массив символов полученную строку.
        boolean isCheckVar = false;                                                     // Управляющая переменная для проверок.
        if (inputFromConsole.indexOf("_") > 0) {                                      // Если _ нет, то Java
            for (int index = 0; index < charsArrayFromInputString.length; index++) {   //Если есть, то проверка на заглавные
                if (Character.isUpperCase(charsArrayFromInputString[index])) {
                    isCheckVar = true;                              // Возврат значения true, если есть заглавные.
                }
            }
        } else {
            return "Java";
        }
        if (isCheckVar) {       // Если true, то значит смешанный тип. Если false - С++.
            return "MixType";
        } else {
            return "C++";
        }
    }

    private static StringBuilder getChangeStringToCStyle(String inputFromConsole) {             // Метод смена стиля напиисания имени ппеременной с С++ на Java.
        StringBuilder changeString = new StringBuilder(inputFromConsole);
        for (int count = 0; count < changeString.length(); count++) {                           // Цикл для обработки строки.
            if (Character.isUpperCase(changeString.charAt(count))) {                            // Проверка на строчные буквы
                changeString.insert(count + 1, Character.toLowerCase(changeString.charAt(count)));
                changeString.replace(count, count + 1, "_");
                count++;
            }
        }
        return changeString;
    }

    private static StringBuilder getChangeStringToJavaStyle(String inputFromConsole) {              // Метод смена стиля напиисания имени ппеременной с Java на С++.
        StringBuilder changeString = new StringBuilder(inputFromConsole);
        for (int count = 0; count < changeString.length(); count++) {                               // Цикл для поиска в строке.
            if (String.valueOf(changeString.charAt(count)).indexOf("_") == 0) {                     // Проверка на символ _.
                changeString.insert(count, Character.toUpperCase(changeString.charAt(count + 1)));  // Смена регистра символа по вычисленной позиции и вставка по этой позиции прописной буквы.
                changeString.delete(count + 1, count + 3);                                          // Удаление строчной буквы и _.
            }
        }
        return changeString;
    }
}
