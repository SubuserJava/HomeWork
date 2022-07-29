package com.company.homework.homework2;

import java.util.Scanner;

public class Task02 {

    public static void main(String[] args) {

        int mainNumber;

        System.out.println("Enter natural three-digit number: ");
        Scanner scanner = new Scanner(System.in);
        mainNumber = scanner.nextInt();

        int calcResultUnit = mainNumber % 10;
        int calcResultHundreds = ((mainNumber - calcResultUnit) - ((mainNumber - calcResultUnit) % 100)) / 100;
        int calcResultTens = ((mainNumber - calcResultUnit) - calcResultHundreds * 100) / 10;
        int sumDigitsResult = calcResultUnit + calcResultHundreds + calcResultTens;

        System.out.println("Sum of all numbers of " + mainNumber + " is " + sumDigitsResult);
    }
}
