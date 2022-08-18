package com.company.homework.homework4_2;

import java.util.Scanner;

public class Task05 {

    public static void main(String[] args) {

        Scanner consoleInput = new Scanner(System.in);

        int heightParallelogram;
        do {
            System.out.print("Enter height of parallelogram - ");
            heightParallelogram = consoleInput.nextInt();
            if (heightParallelogram < 2) {
                System.out.println("You entered too small value. Please, enter again height not more less 2.");
            }
        } while (heightParallelogram < 2);

        int widthParallelogram;
        do {
            System.out.print("Enter width of parallelogram - ");
            widthParallelogram = consoleInput.nextInt();
            if (widthParallelogram < 2) {
                System.out.println("You entered too small value. Please, enter again width not more less 2.");
            }
        } while (widthParallelogram < 2);

        System.out.print("Enter indent from the left side of console - ");
        int indentFromLeft = consoleInput.nextInt();

        int fullEmpty = 0;
        do {
            System.out.print("Please, enter which parallelogram to print full '1' or empty '0'- ");
            fullEmpty = consoleInput.nextInt();
            if (fullEmpty > 1) {
                System.out.println("You entered so big value. Please, enter again '0' or '1'.");
            }
        } while (widthParallelogram < 2);
        System.out.println();

        printTopLine(indentFromLeft, widthParallelogram, heightParallelogram);
        printMiddlePart(indentFromLeft, widthParallelogram, heightParallelogram, fullEmpty);
        printBottomLine(indentFromLeft, widthParallelogram);

    }

    private static void printTopLine(int indentFromLeft, int widthParallelogram, int heightParallelogram) {
        for (int indentCount = 0; indentCount < indentFromLeft + heightParallelogram - 1; indentCount++) {  // Высота - 1, т.к. высота без учёта нижней строки.
            System.out.print(" ");
        }
        for (int topLineCount = 0; topLineCount < widthParallelogram; topLineCount++) {
            System.out.print("*");
        }
        System.out.println();
    }

    private static void printMiddlePart(int indentFromLeft, int widthParallelogram, int heightParallelogram, int fullEmpty) {
        int indentArg = indentFromLeft + heightParallelogram - 2; // Высота - 2, т.к. из общей высоты выкидываются верхняя и нижняя строки
        for (int innerlineCount = 0; innerlineCount < heightParallelogram - 2; innerlineCount++) {
            for (int indentCount = 0; indentCount < indentArg; indentCount++) {
                System.out.print(" ");
            }
            System.out.print("*");
            indentArg -= 1;
            for (int innerPartcount = 0; innerPartcount < widthParallelogram - 2; innerPartcount++) {
                if (fullEmpty == 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("*");
            System.out.println();
        }
    }

    private static void printBottomLine(int indentFromLeft, int widthParallelogram) {
        for (int indentCount = 0; indentCount < indentFromLeft; indentCount++) {
            System.out.print(" ");
        }
        for (int bottomLineCount = 0; bottomLineCount < widthParallelogram; bottomLineCount++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
