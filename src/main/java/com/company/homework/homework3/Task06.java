package com.company.homework.homework3;

import java.util.Scanner;

public class Task06 {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in); // Ввод года
        System.out.print("Enter any year from 0 to infinity.\n" +
                "Year - ");
        long enteredYear = console.nextLong();

        if (enteredYear % 400 == 0) {
            System.out.println("Year is leap. Volume of day in this year is 366.");
        } else if (enteredYear % 100 == 0) {
            System.out.println("Year is not leap. Volume of day in this year is 365");
        } else if (enteredYear % 4 == 0) {
            System.out.println("Year is leap. Volume of day in this year is 366.");
        } else {
            System.out.println("Year is not leap. Volume of day in this year is 365");
        }
    }
}
