package com.company.homework.homework6_2;


public class ExampleOfRecursion {

    public static void main(String[] args) {
        System.out.println(recursion(12345)); // вызов рекурсивной функции
    }

    public static String recursion(int n) {
        // Базовый случай
        if (n < 10) {
            return Integer.toString(n);
        } // Шаг рекурсии / рекурсивное условие
        else {
            return recursion(n / 10) + " " + n % 10;
        }
    }
}
