package com.company.homework.homework5_1;

import java.util.Scanner;

public class Task02 {

    public static void main(String[] args) {

        Scanner consoleInput = new Scanner(System.in);
        System.out.print("Enter the position in the string of numbers - ");
        int positionNumber = consoleInput.nextInt();

        int stringLength = 0;
        StringBuilder stringNumbers = new StringBuilder();

        while (stringNumbers.length() <= 1000) {              // Бесконечный цикл создания строки с цифрами до кол-ва символов в строке 1000.
            stringNumbers = stringNumbers.append(stringNumbers.length());    // Заполнение значениями длины строки. Первая цифра - 0, вторая - 1, и т.д.
        }

        System.out.println("String number: " + stringNumbers);
        System.out.println("Number on " + positionNumber + " position is " + stringNumbers.charAt(positionNumber - 1) + ".");
    }
}
