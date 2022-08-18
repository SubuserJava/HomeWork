package com.company.homework.homework4_1;

import java.util.Scanner;

public class Task12 {

    public static void main(String[] args) {

        double firstDayKmtrs = 1.5f;    // Предположим, что в первый день спортсмен пробежал 1,5 км. (x). Число может меняться.

        System.out.println("Enter the number of kilometers more than the athlete ran on the first day: " + firstDayKmtrs + "km");
        Scanner console = new Scanner(System.in);
        System.out.println("Number of kilometers: ");
        double totalKmtrs = console.nextDouble();        // Вводим общее число км пробега (y) спортсмена на день, который надо вычислить.

        double varKmtrs = totalKmtrs;                    // Переменнная varKmtrs для сохранения ведённого числа км в переменной totalKmtrs.
        int dayCount = 0;                                // Объявляем и инициализируем Счетчик дней.
        while (varKmtrs > firstDayKmtrs) {
            varKmtrs = varKmtrs - (varKmtrs / 11);       // Выполнение вычисления 10% пробега каждый день.
            dayCount++;                                  // Подсчёт дней, пока расчёт не станет меньше километров за первый день.
        }
        System.out.println("The total mileage will be at least " + totalKmtrs + "km on " + dayCount + " day");  // При вводе 6 км, ответ - 15 дней
    }
}
