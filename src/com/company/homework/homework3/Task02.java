package com.company.homework.homework3;// задача проверки времени. Задача 3.2

import java.util.Scanner;

public class Task02 {

    public static void main(String[] args) {

        Scanner consoleSystemIn = new Scanner(System.in); // Ввод времени.
        System.out.print("Enter the time in format from 0 to 24: ");
        short enterTime = consoleSystemIn.nextShort();

        if (enterTime == 0) {                           // Проверка принадлежности к времени суток.
            System.out.println("Midnight, friend!");
        } else if (enterTime > 0 && enterTime < 6) {
            System.out.println("Good night, friend!");
        } else if (enterTime >= 6 && enterTime < 12) {
            System.out.println("God morning, friend!");
        } else if (enterTime ==12) {
            System.out.println("It's noon!");
        } else if (enterTime > 12 && enterTime <= 18) {
            System.out.println("God day, friend!");
        } else {
            System.out.println("God evening, friend!");
        }
    }
}
