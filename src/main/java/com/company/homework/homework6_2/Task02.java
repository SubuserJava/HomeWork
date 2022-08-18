package com.company.homework.homework6_2;

import java.util.Scanner;

public class Task02 {

    public static void main(String[] args) {

        Scanner consoleInput = new Scanner(System.in);
        System.out.print("Enter number N.\n" +
                "Number N: ");
        exactPowerOfTwo(consoleInput.nextInt(), 1);   // Переменная для возведения 2-ки в степень.
    }

    private static void exactPowerOfTwo(int inputNumber, int tempVar) {
//        tempVar = tempVar * 2;                // "Возведение" в степень двойки.
        if (tempVar == inputNumber) {         // Проверка совпадения с самим числом
            System.out.println("Yes");
            return;
        } else if (tempVar > inputNumber) {
            System.out.println("No");
            return;
        }
        exactPowerOfTwo(inputNumber, tempVar * 2);   // Рекурсивный вызов метода.
    }
}
