package com.company.homework.homework3;

import java.util.Scanner;

public class Task11 {

    public static void main(String[] args) {

        Scanner consoleSystemIn = new Scanner(System.in);                            // Ввод коэфицентов a, b, c квадратного уравнения.
        System.out.print("Enter the coefficients a b c of the quadratic equation.\n" +
                "Condition, that a number is not equal to 0\n" +
                "Coefficient a: ");
        float varA = consoleSystemIn.nextFloat();
        System.out.print("Coefficient b: ");
        float varB = consoleSystemIn.nextFloat();
        System.out.print("Coefficient c: ");
        float varC = consoleSystemIn.nextFloat();

        float discriminantD = (float) Math.pow(varB, 2) - 4.0f * varA * varC; // Вычисление дискриминанты квадратного уравнения.

        if (discriminantD > 0) {                                  // Вывод в консоль и вычисление квадратных корней если они есть.
            System.out.println("First quadratic root is " + (-varB + Math.sqrt(discriminantD)) / 2 * varA);
            System.out.println("Second quadratic root is " + (-varB - Math.sqrt(discriminantD)) / 2 * varA);
        } else if (discriminantD == 0) {
            System.out.println("One quadratic root is " + (-varB / 2 * varA));
        } else {
            System.out.println("No quadratic roots");
        }
    }
}

