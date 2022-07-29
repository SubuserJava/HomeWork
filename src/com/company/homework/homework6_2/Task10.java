package com.company.homework.homework6_2;

public class Task10 {

    private static int firstNum = 96;
    private static int secondNum = 140;

    public static void main(String[] args) {

        System.out.println("Common divisor for " + firstNum + " and " + secondNum + " is: " + checkMaxDivisor(firstNum, secondNum));  // 4
    }

    private static int checkMaxDivisor(int firstNum, int secondNum) {

        if (secondNum == 0) {                                           // Условие для выхода из рекурсии.
            return firstNum;
        }
        return checkMaxDivisor(secondNum, firstNum % secondNum);        // Вызов рекурсивного метода со сменой местами значений
    }                                                                   // чтобы поменять местами что на что делить в следующем шаге рекурсии для получения остатка.
}
