package com.company.homework.homework6_2;

public class Task08 {

    public static void main(String[] args) {
        long powerNumber = 1;
        raisedToThePower(5, 5, powerNumber);
    }

    private static void raisedToThePower(int number, int power, long powerNumber) {

        if (power == 0) {
            System.out.println(powerNumber);
            return;
        }
        raisedToThePower(number, power -= 1,powerNumber *= number);
    }
}
