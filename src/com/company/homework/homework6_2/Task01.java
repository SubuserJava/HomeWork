package com.company.homework.homework6_2;

import java.util.Scanner;

public class Task01 {

    public static void main(String[] args) {

        Scanner consoleInput = new Scanner(System.in);
        System.out.print("Enter number A and B.\n" +
                "Number a: ");
        int inputANum = consoleInput.nextInt();
        System.out.print("Number b: ");
        int inputBNum = consoleInput.nextInt();
        printNumbersBetweenTwo(inputANum, inputBNum);
    }

    public static void printNumbersBetweenTwo(int inputANum, int inputBNum) {
        if (inputBNum > inputANum) {                  // Проверка чисел - больше/меньше друг друга.
            System.out.println(inputANum);
            inputANum++;
        } else {
            System.out.println(inputANum);
            inputANum--;
        }
        if (inputANum == inputBNum) {                 // При равенстве чисел - выход из рекурсии.
            System.out.println(inputANum);
            return;
        }
        printNumbersBetweenTwo(inputANum, inputBNum); // Рекурсивный вызов метода.
    }
}
