package com.company.homework.homework2;

import java.util.Scanner;

public class Task07 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter the annual bank interest (%) on the deposit: ");
        int interestDeposit = in.nextInt();
        System.out.print("Enter the deposit amount: ");
        float amountDeposit = in.nextFloat();
        System.out.print("Enter the number of years of deposit: ");
        int yearsDeposit = in.nextInt();

        float accuredInterest;
        float totalDepositAmount;
        accuredInterest = interestDeposit * amountDeposit / 100 * yearsDeposit;
        totalDepositAmount = amountDeposit + accuredInterest;

        System.out.println("Total deposit amount for " + yearsDeposit + " year is " + totalDepositAmount);
        System.out.println("Deposit interest amount is " + accuredInterest);

    }
}
