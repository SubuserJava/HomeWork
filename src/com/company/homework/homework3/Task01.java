package com.company.homework.homework3;

// Задача проверки числа от 1 до 7 на соответствие дню недели. Залдача 3.1

import java.util.Scanner;

public class Task01 {

    public static void main(String[] args) {

        String[] WeekDaysArray = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", // Массив дней недели
                "Thursday", "Friday", "Saturday", "Sunday"};

        Scanner consoleSystemIn = new Scanner(System.in);                          // Ввод числа дня из недели
        System.out.print("Enter the number of the day of the week: ");
        byte numberDay = consoleSystemIn.nextByte();

        switch (numberDay) {                                          // Вывод название дня недели
            case (1) -> System.out.println("Your day is :" + WeekDaysArray[0]);
            case (2) -> System.out.println("Your day is :" + WeekDaysArray[1]);
            case (3) -> System.out.println("Your day is :" + WeekDaysArray[2]);
            case (4) -> System.out.println("Your day is :" + WeekDaysArray[3]);
            case (5) -> System.out.println("Your day is :" + WeekDaysArray[4]);
            case (6) -> System.out.println("Your day is :" + WeekDaysArray[5]);
            case (7) -> System.out.println("Your day is :" + WeekDaysArray[6]);
            default -> System.out.println("Your number not number of week.");
        }
    }
}
