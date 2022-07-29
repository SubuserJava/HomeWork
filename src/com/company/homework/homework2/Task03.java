package com.company.homework.homework2;

import java.util.Scanner;

public class Task03 {

    public static void main(String[] args) {

        float inputNumber;
        int resultCastingType;
        int calcResultFinal;

        System.out.print("Enter any real number with fractional part: ");
        Scanner in = new Scanner(System.in);
        inputNumber = in.nextFloat();

        resultCastingType = (int) inputNumber;

        if (inputNumber - resultCastingType < 0.5) {
            calcResultFinal = resultCastingType;
        } else {
            calcResultFinal = resultCastingType + 1;
        }

        System.out.println("The resul of mathematical rounding the number: " + inputNumber + " is " + calcResultFinal);
    }
}
