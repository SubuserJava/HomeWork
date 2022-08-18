package com.company.homework.homework2;

import java.util.Scanner;

public class Task09 {

    public static void main(String[] args) {

        double intermediateResult;

        Scanner in = new Scanner(System.in);
        System.out.println("Enter any number - ");
        double enteredNumber = in.nextDouble();

        intermediateResult = enteredNumber - (int) enteredNumber;

        if (intermediateResult != 0) {
            System.out.println("This number has a real part.");
        } else {
            System.out.println("This number hasn't a real part.");
        }
    }
}
