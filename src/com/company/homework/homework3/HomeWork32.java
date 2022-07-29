package com.company.homework.homework3;

import java.util.Scanner;

public class HomeWork32 {                                     // Небольшой калькулятор на 4 действия.

    private static final String OPERATION_SYMBOL_1 = "+";
    private static final String OPERATION_SYMBOL_2 = "-";
    private static final String OPERATION_SYMBOL_3 = "*";

    public static void main(String[] args) {

        double calcResult1, calcResult2, calcResult3, calcResult4, calcResult5;
        double num1, num2;

        Scanner scannerIn = new Scanner(System.in); // Input 2 digits
        System.out.print("Enter the symbol for the desired action in format +, -, *, /: ");
        String inputOperationSymbol = scannerIn.nextLine();
        System.out.print("Enter any 1st number: ");
        num1 = scannerIn.nextDouble();
        System.out.print("Enter any 2nd number: ");
        num2 = scannerIn.nextDouble();

        switch (inputOperationSymbol) {        // different calculations
            case OPERATION_SYMBOL_1:
                calcResult1 = num1 + num2;
                System.out.println("The result of sum: " + num1 + " + " + num2 + " = " + calcResult1);
                break;
            case OPERATION_SYMBOL_2:
                calcResult2 = num1 - num2;
                System.out.println("The result of substracting: " + num1 + " - " + num2 + " = " + calcResult2);
                break;
            case OPERATION_SYMBOL_3:
                calcResult3 = num1 * num2;
                System.out.println("The result of multuplying: " + num1 + " * " + num2 + " = " + calcResult3);
                break;
            default:
                calcResult4 = num1 / num2;
                System.out.printf("The result of division: " + num1 + " * " + num2 + " = " + "%.4f \n", calcResult4);
        }

        System.out.print("Enter any number to raise to the power: ");
        num1 = scannerIn.nextDouble();
        System.out.print("Enter any degree of the number: ");
        num2 = scannerIn.nextDouble();

        calcResult5 = Math.pow(num1, num2);

        System.out.printf("The result of raising : " + num1 + "\u005e" + num2 + " = " + "%.4f \n", calcResult5);
    }
}
