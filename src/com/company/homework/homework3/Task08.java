package com.company.homework.homework3;

public class Task08 {

    public static void main(String[] args) {

        long x = 2; // Сменяемый параметр
        long y = 2;

        if ((x % 2) == 0 & (y % 2) == 0 || (x % 2) != 0 & (y % 2) != 0) { // Проверка на чётность обеих чисел
            System.out.println("YES");
        }
    }
}
