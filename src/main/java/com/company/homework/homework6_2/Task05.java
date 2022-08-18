package com.company.homework.homework6_2;

public class Task05 {

    public static void main(String[] args) {

        double number = 12345d;
        System.out.println("Your number is " + (int)number);
        System.out.print("Straight print to console: ");
        printNumber(number, 10d);   // Делитель = 10 для первого входа в метод и вычисления единиц.
    }                                                  // По аналогии с заданием 3.

    private static void printNumber(double number, double controlDelimiter) {

        if (number == 0) {
            return;
        }
        printNumber(number - number % controlDelimiter, controlDelimiter * 10);
        System.out.print((int) (number % controlDelimiter / controlDelimiter * 10) + " ");  // Печать 1 2 3 4 5
    }
}