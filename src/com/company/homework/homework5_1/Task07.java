package com.company.homework.homework5_1;

import java.util.Scanner;

public class Task07 {

    public static void main(String[] args) {

        Scanner consoleInput = new Scanner(System.in);          // Ввод строки без проверки на другие символы.
        System.out.println("Enter any phrase.");
        String inputFromConsole = consoleInput.nextLine();
        char[] charArrayFromInputString = inputFromConsole.toCharArray();

        for (int index = 0; index < charArrayFromInputString.length; index++) {    // Цикл проверки и замены по условию задачи.
            char charFromInputString = charArrayFromInputString[index];
            if (Character.isUpperCase(charFromInputString)) {                      // Замена на строчные буквы если прописные
                charArrayFromInputString[index] = Character.toLowerCase(charFromInputString);
            } else if (Character.isLowerCase(charFromInputString)) {               // Замена на прописные если строчные.
                charArrayFromInputString[index] = Character.toUpperCase(charFromInputString);
            }
            if (Character.isDigit(charFromInputString)) {                          // Замена цифр на _
                charArrayFromInputString[index] = '_';
            }
        }
        System.out.println(charArrayFromInputString);
    }
}
