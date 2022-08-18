package com.company.homework.homework2;

public class Task10 {

    static final int HIGHT = 183;
    static final  int WEIGHT = 85;

    public static void main(String[] args) {

        int finalCalculation;
        int idealWeight = HIGHT - 110;

        if (idealWeight > WEIGHT) {
            finalCalculation = idealWeight - WEIGHT;
            System.out.println("You need to lose " + finalCalculation + "kg to your ideal weight of" + WEIGHT + "kg for the " + HIGHT + "sm.");
        } else if (idealWeight < WEIGHT) {
            finalCalculation = WEIGHT - idealWeight;
            System.out.println("You need to gain " + finalCalculation + "kg to your ideal weight " + WEIGHT + "kg for the " + HIGHT + "sm.");
        } else {
            System.out.println("Your weight is ideal!");
        }
    }
}
