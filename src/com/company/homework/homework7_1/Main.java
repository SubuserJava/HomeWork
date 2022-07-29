package com.company.homework.homework7_1;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

//        Scanner consoleInput = new Scanner(System.in);
//        double a = 1.122;
//        System.out.println(a % 100);

        LocalDate date = LocalDate.of(2022, 5, 10);
        date = date.plusDays(10);
        System.out.println(date);
        LocalDate today = LocalDate.now();
        System.out.println(today);

        int resultCompareDates = date.compareTo(today);
        if (resultCompareDates == 0) {
            System.out.println("Date is equal to Date now");
        } else if (resultCompareDates > 0) {
            System.out.println("Date is after Date now");
        } else if (resultCompareDates < 0) {
            System.out.println("Date is before Date now");
        } else {
            System.out.println("How to get here?");
        }

//        String newDataString = consoleInput.nextLine();
//        System.out.println(newDataString);
//        int newDataInt = consoleInput.nextInt();
//        System.out.println(newDataInt);
//        String newDataString1 = consoleInput.nextLine();
//        System.out.println(newDataString1);
    }
}
