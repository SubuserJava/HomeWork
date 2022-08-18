package com.company.homework.homework2;

import java.util.Scanner;

public class Task11 {

    static final int SECOND_IN_MINUTE = 60;
    static final int SECOND_IN_HOUR = SECOND_IN_MINUTE * 60;
    static final int SECOND_IN_DAY = 24 * SECOND_IN_HOUR;

    public static void main(String[] args) {

        int resultDays;
        int resultHours;
        int resultMinutes;
        int resultSeconds;

        Scanner console = new Scanner(System.in);
        System.out.print("Enter the number of seconds: ");
        int inputSeconds = console.nextInt();

        resultDays = inputSeconds / SECOND_IN_DAY;
        resultHours = inputSeconds % SECOND_IN_DAY / SECOND_IN_HOUR;
        resultMinutes = inputSeconds % SECOND_IN_DAY % SECOND_IN_HOUR / SECOND_IN_MINUTE;
        resultSeconds = inputSeconds % SECOND_IN_DAY % SECOND_IN_HOUR % SECOND_IN_MINUTE;

        System.out.println(resultDays + " days, " + resultHours + " hours, " + resultMinutes + " minutes, " + resultSeconds + " second left until the New Year.");
    }
}

