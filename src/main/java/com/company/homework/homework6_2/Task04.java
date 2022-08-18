package com.company.homework.homework6_2;

public class Task04 {

    public static void main(String[] args) {

        double number = 12345d;
        System.out.println("Your number is " + (int)number);
        System.out.print("Print to console in reverse mode: ");
        printNumber(number, 10d);   // Делитель = 10 для первого входа в метод и вычисления единиц.
    }                                                  // По аналогии с заданием 3.

    private static void printNumber(double number, double controlDelimiter) {

        if (number == 0) {
            return;
        }
        System.out.print((int)(number % controlDelimiter / controlDelimiter * 10) + " ");  // Печать 5 4 3 2 1
        printNumber(number - number % controlDelimiter, controlDelimiter * 10);
    }
}
