package com.company.homework.homework4_2;

import java.util.Scanner;

public class Task08 {

    public static void main(String[] args) {

        Scanner consoleSystemIn = new Scanner(System.in);
        System.out.print("Enter any positive integer.\n" +
                "Value - ");
        long number = consoleSystemIn.nextLong();
        System.out.print("The number of digits in a number and the sum of those numbers: ");

        long tempNumberVar = 0;        // Переменная для знаяения единиц, десятков, сотен и т.д.
        long countSumNumbers = 0;         // Переменная для подсчёта кол-ва чисел в числе.
        long mainDelimiter = 10;       // Основной делитель при делении по модулю.
        long remainderDelimiter = 1;   // Второй делитель для остатка деления по модулю.
        int countNumber = 0;           // Подсчёт общего количества чисел в числе.
        while (number % mainDelimiter != number) {                          // Цикл бесконечный пока число делится на само себя с остатком.
            tempNumberVar = number % mainDelimiter / remainderDelimiter;    // Вычисление единиц, десятков, сотен и т.д.
            countSumNumbers += tempNumberVar;                        // Суммирование цифр из числа.
            countNumber += 1;
            mainDelimiter *= 10;
            remainderDelimiter *= 10;
        }

        tempNumberVar = number / (mainDelimiter / 10);     // Вычисление числа последнего разряда.
        countSumNumbers += tempNumberVar;
        countNumber += 1;
        System.out.print(countNumber + ", " + countSumNumbers);
    }
}
