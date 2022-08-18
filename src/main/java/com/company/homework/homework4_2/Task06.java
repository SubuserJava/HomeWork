package com.company.homework.homework4_2;

import java.util.Scanner;

public class Task06 {

    public static void main(String[] args) {

        Scanner consoleSystemIn = new Scanner(System.in);     // Ввод значений без проверки на 0 и минимального кол-ва ступеней.
        System.out.print("Enter the number of steps.\n" +
                "Value steps - ");
        int numSteps = consoleSystemIn.nextInt();
        System.out.print("Enter indent from left.\n" +
                "Value indent - ");
        int indentFromLeft = consoleSystemIn.nextInt();
        System.out.println();

        int indentStepLine = 0;
        int indentInnerSpace = 2;
        for (int indentStepCount = 0; indentStepCount < numSteps - 1; indentStepCount++) {
            for (int indentCount = 0; indentCount < indentFromLeft + indentStepLine; indentCount++) { // Печать пробелов в общем отступе слева
                System.out.print(" ");
            }
            for (int stepTopLine = 0; stepTopLine < 3; stepTopLine++) {   // Печать верхней линии ступени.
                System.out.print("*");
            }
            System.out.println();
            for (int betweenSteps = 0; betweenSteps < indentInnerSpace + indentFromLeft; betweenSteps++) {   // Печать пробелов под линией ступени
                System.out.print(" ");
            }
            System.out.println("*");   // Печать разделительной * между ступенями.
            indentStepLine += 2;
            indentInnerSpace += 2;

        }

        for (int indentBottomStep = 0; indentBottomStep < indentFromLeft + indentStepLine; indentBottomStep++) {  // Печать пробелов до линии последней ступени
            System.out.print(" ");
        }
        for (int bottomLineCount = 0; bottomLineCount < 3; bottomLineCount++) {      // Линия последней ступеньки.
            System.out.print("*");
        }
        System.out.println();
    }


}
