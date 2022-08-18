package com.company.homework.homework6_2;

import java.util.Scanner;

public class Task09 {

    public static void main(String[] args) {

        Scanner consoleInput = new Scanner(System.in);
        System.out.print("Enter begin number and finish separated by spaces: ");    // Ввод числа, разделёные пробелами.
        String inputNumber = consoleInput.nextLine();
        String[] tempStringArray = inputNumber.split(" ");
        int startNum = Integer.parseInt(tempStringArray[0]);     // Начальное число
        int endNum = Integer.parseInt(tempStringArray[1]);       // Конечное число

        int totalSumNum = startNum;
        sumBetweenTwoNumbers(startNum, endNum, totalSumNum);
    }

    private static void sumBetweenTwoNumbers(int startNum, int endNum, int totalSumNum) {

        if (startNum == endNum) {                                                 // Условие выхода.
            System.out.println("Sum beetwen two numbers is " + totalSumNum);
            return;
        }
        totalSumNum += startNum + 1;                                              // Суммирование чисел.
        sumBetweenTwoNumbers(startNum + 1, endNum, totalSumNum);          // Рекурсивный вызов метода.
    }
}
