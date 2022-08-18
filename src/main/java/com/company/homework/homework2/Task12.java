package com.company.homework.homework2;

import java.util.Scanner;

public class Task12 {

    public static void main(String[] args) {

        float numberStudents;
        float numberStudentsLessWeight;
        float numberStudentsMoreWeight;
        float notStandardNumbersPies = 2f;
        int condition;
        float glassMilkVolume = 0.2f;
        float packMilkVolume = 0.9f;

        Scanner console = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        numberStudents = console.nextInt();
        System.out.print("Enter the solution condition\n" +
                "1 - 100% of students weigh less than 30 kg.\n" +
                "2 - 60% of students weigh less than 30 kg.\n" +
                "3 - 1% of students weigh less than 30 kg.\n" +
                "Condition - ");
        condition = console.nextInt();

        float finalResultPies;
        float finalResultMilk;

        if (condition == 1) {
            finalResultPies = numberStudents * notStandardNumbersPies;
            finalResultMilk = numberStudents * glassMilkVolume / packMilkVolume;
            System.out.println("Number of pies is " + (int)finalResultPies + " \n" +
                    "and milk cartons is " + (int)Math.ceil(finalResultMilk) + " per day.");
        } else if (condition == 2) {
            numberStudentsLessWeight = numberStudents * 0.6f;
            numberStudentsMoreWeight = numberStudents - numberStudentsLessWeight;
            finalResultPies = (numberStudentsLessWeight * notStandardNumbersPies) + numberStudentsMoreWeight;
            finalResultMilk = (float)Math.ceil(numberStudentsLessWeight) * glassMilkVolume / packMilkVolume;
            System.out.println("Number of pies is " + (int) Math.ceil(finalResultPies) + " \n" +
                    "and milk cartons is " + (int) Math.ceil(finalResultMilk) + " per day.");
        } else if (condition == 3) {
            if (numberStudents / 100 <= 1.0f) {
                numberStudentsLessWeight = 1;
                numberStudentsMoreWeight = numberStudents - numberStudentsLessWeight;
                finalResultPies = notStandardNumbersPies + numberStudentsMoreWeight;
                finalResultMilk = 1;
                System.out.println("Number of pies is " + (int) Math.ceil(finalResultPies) + " \n" +
                        "and milk cartons is " + (int) Math.ceil(finalResultMilk) + " per day.");
            } else {
                numberStudentsLessWeight = numberStudents / 100;
                numberStudentsMoreWeight = numberStudents - numberStudentsLessWeight;
                finalResultPies = (numberStudentsLessWeight * notStandardNumbersPies) + numberStudentsMoreWeight;
                finalResultMilk = (float)Math.ceil(numberStudentsLessWeight) * glassMilkVolume / packMilkVolume;
                System.out.println("Number of pies is " + (int) Math.ceil(finalResultPies) + " \n" +
                        "and milk cartons is " + (int) Math.ceil(finalResultMilk) + " per day.");
            }
        }
    }
}
