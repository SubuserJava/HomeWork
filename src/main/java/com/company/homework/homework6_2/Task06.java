package com.company.homework.homework6_2;

import java.util.Scanner;

public class Task06 {

    public static void main(String[] args) {

        Scanner consoleInput = new Scanner(System.in);
        System.out.print("Enter any number without zero.\nYour number: ");
        double numberFromConsole = consoleInput.nextDouble();
        double calcNumber = 0;
        printNumber(numberFromConsole, 10d, calcNumber);   // Делитель = 10 для первого входа в метод и вычисления единиц.
    }                                                  // По аналогии с заданием 3, 4, 5/

    private static void printNumber(double numberFromConsole, double controlDelimiter, double calcNumber) {

        if (numberFromConsole == 0) {
            System.out.println("Your number in revers mode: " + (int)calcNumber);   // 123456 -> 654321.
            return;
        }
        calcNumber += numberFromConsole % controlDelimiter / controlDelimiter;
        printNumber(numberFromConsole - numberFromConsole % controlDelimiter, controlDelimiter * 10, calcNumber * 10);

    }
}
