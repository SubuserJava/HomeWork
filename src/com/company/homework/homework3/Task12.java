package com.company.homework.homework3;

import java.util.Scanner;

public class Task12 {

    public static void main(String[] args) {

        Scanner consoleSystemIn = new Scanner(System.in);       // Ввод шестизначного числа
        System.out.println("Enter 6 digit number.");
        String enteredNumber = consoleSystemIn.nextLine();

        int firstThreeNumber = 0;
        for (int i = 0; i < 3; i++) {                    // Парсинг строки. Вычисление суммы первых трёх чисел во введённом числе.
            char a1 = enteredNumber.charAt(i);
            int b1 = Integer.parseInt(String.valueOf(a1));
            firstThreeNumber += b1;
        }

        int secondThreeNumber = 0;
        for (int i = 3; i < 6; i++) {                    // Парсинг строки. Вычисление суммы последних трёх чисел из введённого числа.
            char a2 = enteredNumber.charAt(i);
            int b2 = Integer.parseInt(String.valueOf(a2));
            secondThreeNumber += b2;
        }

        if (firstThreeNumber == secondThreeNumber) {     // Сравнение сумм чисел и вывод результата.
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
