package com.company.homework.homework4_2;

import java.util.Scanner;

public class Task07 {

    public static void main(String[] args) {

        Scanner consoleSystemIn = new Scanner(System.in);
        System.out.print("Enter any positive integer.\n" +
                "Value - ");
        long number = consoleSystemIn.nextLong();
        System.out.print("Number reverse - ");

        long tempNumber = 0;
        long controlDelimiter = 10;   // Начинается с 10 для выявления единиц при первом делении по модулю.
        long delimiter = 1;
        while (number % controlDelimiter != number) {     // Цикл бесконечный, пока при делении по модулю будет остаток а не само число.
            tempNumber = number % controlDelimiter / delimiter;    // Вычисление единиц, десятков, сотен и т.д.
            System.out.print(tempNumber); // Вывод в консоль каждого числа
            controlDelimiter *= 10;      // Управляющая переменная делителем по модулю.
            delimiter *= 10;
        }

        tempNumber = number / (controlDelimiter / 10);  // Вычисление значения последнего разряда числа.
        System.out.print(tempNumber);                   // Вывод в консоль последнего числа единиц.
    }
}
