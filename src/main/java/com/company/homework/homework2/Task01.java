package com.company.homework.homework2;

public class Task01 {

    public static void main(String[] args) {

        int naturalNumber1 = 130;
        int naturalNumber2 = 98;
        float resultNumber1;
        double resultNumber2;
        double resultNumber3;

        resultNumber1 = (float)naturalNumber1 / (float)naturalNumber2;
        resultNumber2 = (double) naturalNumber1 % (double)naturalNumber2;
        resultNumber3 = Math.sqrt(naturalNumber1);

        System.out.println("The result of integer division of " + naturalNumber1 + " by " + naturalNumber2 + " is " + resultNumber1);
        System.out.println("The remainder of division of " + naturalNumber1 + " by " + naturalNumber2 + " is " + resultNumber2);
        System.out.println("The result of taken the square root of the number" + naturalNumber1 + " is " + resultNumber3);

    }
}
