package com.company.homework.homework7_1.Task03;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner consoleInput = new Scanner(System.in);
        long grivna;
        byte kopecks;
        for (; ; ) {                                                 // Цикл с проверкой правильности ввода данных.
            System.out.print("Enter value of money.\nGrivna: ");
            grivna = consoleInput.nextLong();
            System.out.print("Kopecks: ");
            kopecks = consoleInput.nextByte();
            if (grivna < 0) {
                System.out.println("Grivna value can't be less than 0. Please, enter your value of money correctly.");
            } else if (kopecks > 100) {
                System.out.println("Kopecks value can't be more than 100. Please, enter your value of money correctly");
            } else {
                break;
            }
        }
        Money money = new Money(grivna, kopecks);                    // Создаём экземпляр класса.
        System.out.println(money);

        System.out.print("Specify what you want to do with your amount.\n" +
                "1. Adding money.\n2. Subtraction of money.\n3. Division of money on integer number. Division of money on a fractional number. (Example 2 or 2,5)\n" +
                "4. Multiplication of money by a fractional number (Example 2,5).\n5. Operation comparisons of money.\nYour choice: ");
        int valueOfChoice = consoleInput.nextInt();
        System.out.println();

        double tempNumberDouble = 0;                                                   // Временная переменная double для любых денежных расчётов.
        switch (valueOfChoice) {
            case 1 -> {
                addingMoney(consoleInput, grivna, kopecks, money);
            }
            case 2 -> {
                subtractMoney(consoleInput, grivna, kopecks, money);
            }
            case 3 -> {
                divideMoney(consoleInput, grivna, kopecks, money);
            }
            case 4 -> {
                multiplayMoney(consoleInput, grivna, kopecks, money);
            }
            case 5 -> {
                compareMoney(consoleInput, grivna, kopecks, money);
            }
        }
    }

    private static void compareMoney(Scanner consoleInput, long grivna, byte kopecks, Money money) {
        System.out.print("Enter the amount you want to compare with yours. if fractional then separated by a comma (example 15,15)): \nNumber: ");
        double enteredAmount = consoleInput.nextDouble();
        if (getConvertToDouble(grivna, kopecks) < enteredAmount) {
            System.out.print("Your entered amount of money is greater than available." + money.grivna + "," + money.kopecks);
        } else if (enteredAmount == getConvertToDouble(grivna, kopecks)) {
            System.out.println("Your entered amount of money is equal to the available " + money.grivna + "," + money.kopecks);
        } else {
            System.out.println("Your entered amount of money is less than the available " + money.grivna + "," + money.kopecks);
        }
    }

    private static void multiplayMoney(Scanner consoleInput, long grivna, byte kopecks, Money money) {
        System.out.print("Enter the fractional number you want to multiply separated by a comma(example 15,15): ");
        double enteredAmount = consoleInput.nextDouble();
        double tempNumberDouble = getConvertToDouble(grivna, kopecks) * enteredAmount;

        setValuesAndPrint(money, tempNumberDouble);
    }

    private static void divideMoney(Scanner consoleInput, long grivna, byte kopecks, Money money) {
        // Cовмещено. Можно делить на целое или на дробное.
        System.out.print("Enter an number by which you want to divide your amount, integer or fractional separated by a comma(example 2 or 2,5): ");
        double enteredAmount = consoleInput.nextDouble();
        double tempNumberDouble = getConvertToDouble(grivna, kopecks) / enteredAmount;

        setValuesAndPrint(money, tempNumberDouble);
    }

    private static void subtractMoney(Scanner consoleInput, long grivna, byte kopecks, Money money) {
        System.out.print("Enter the amount you want subtract separated by a comma (example 15,15): ");
        double enteredAmount = consoleInput.nextDouble();
        double tempNumberDouble = getConvertToDouble(grivna, kopecks) - enteredAmount;

        setValuesAndPrint(money, tempNumberDouble);
    }

    private static void addingMoney(Scanner consoleInput, long grivna, byte kopecks, Money money) {
        System.out.print("Enter the amount you want to add separated by a comma (example 15,15): ");
        double enteredAmount = consoleInput.nextDouble();
        double tempNumberDouble = getConvertToDouble(grivna, kopecks) + enteredAmount;

        setValuesAndPrint(money, tempNumberDouble);
    }

    private static void setValuesAndPrint(Money money, double tempNumberDouble) {            // Метод присваивания полям экземпляра класса полученных значений
        money.setGrivna((long) tempNumberDouble);                                            // и вывод на печать изменившейся суммы.
        money.setKopecks((byte) Math.round((tempNumberDouble - (long) tempNumberDouble) * 100));
        System.out.println(money);
    }

    private static double getConvertToDouble(long grivna, byte kopecks) {
        return grivna + (double) kopecks / 100;
    }
}
