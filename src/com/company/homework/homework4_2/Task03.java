package com.company.homework.homework4_2;

import java.util.Scanner;

public class Task03 {

    public static void main(String[] args) {

        Scanner consoleSystemIn = new Scanner(System.in);                // Блок ввода значений треугольника. По условию задачи фигура должна быть симметричной и ровной.
        System.out.print("Enter the height in the string of the isosceles  triangle.\n" +  // Поэтому основание равнобедренного треугольника будет рассчитавается (h*2)-1
                "Full or empty interior of the triangle .\n" +
                "Indent from the left side.\n" +
                "Enter '1' if the triangle is full and '0' if the triangle is empty.\n" +
                "\nValue height - ");
        int heightTriangle = consoleSystemIn.nextInt();
        int baseLineTriangle = heightTriangle * 2 - 1;
        System.out.print("Value full or empty - ");
        int fullEmptyTriangle = consoleSystemIn.nextInt();
        System.out.print("Value indent from the left side - ");
        int indentFromLeft = consoleSystemIn.nextInt();
        System.out.println();

        printTopString(baseLineTriangle, indentFromLeft);
        printMiddlePart(heightTriangle, indentFromLeft, fullEmptyTriangle);
        printBottomString(baseLineTriangle, indentFromLeft);
    }

    private static void printTopString(int baseLineTriangle, int indentFromLeft) {   // Метод печати первой и последней строки.
        for (int TopStringCount = 0; TopStringCount < baseLineTriangle / 2 + indentFromLeft; TopStringCount++) {    // Учитывается отступ indentFromLeft.
            System.out.print(" ");
        }
        System.out.println("*");
    }

    private static void printMiddlePart(int heightTriangle, int indentFromLeft, int fullEmptyTriangle) {  // Метод печати середины ромба.
        int arg1 = heightTriangle - 2;             // Переменные управляющие циклами печати пробелов и *.
        int arg2 = arg1 + indentFromLeft;                 // Переменная управления цикла печати отступа слева с учётом общего отступа.
        int arg3 = 1;                                 // Переменная управления циклом печати в середине строки. 1, т.к. первый символ 1 раз между *.
        for (int middleStringCount = 0; middleStringCount < arg1; middleStringCount++) {          // Общий цикл печати строк в середине треугольника.
            for (int indentCount = 0; indentCount < arg2; indentCount++) {      // Цикл печати символов до "левой" линии.
                System.out.print(" ");
            }
            arg2--;                          // Переменная управления циклом печати символов до левой боковой линии.
            System.out.print("*");                       // Печать символа "*" в начале строки после пробелов слева.

            for (int innerCount = 0; innerCount < arg3; innerCount++) {  // Цикл печати символа * или " " внутри треугольника.
                if (fullEmptyTriangle == 1) {          // Проверка печати пустой/полный треугольник.
                    System.out.print("*");             // "Полный" треугольник.
                } else {
                    System.out.print(" ");             // "Пустой" треугольник.
                }
            }
            arg3 += 2;             // Приращение упр. переменной на 2 позиции. т.к. на каждой новой строчке увеличение на 2 символа.
            System.out.print("*"); // Символ "*" в конце строки.
            System.out.println();  // Перевод строки.
        }
    }

    private static void printBottomString(int baseLineTriangle, int indentFromLeft) {   // Метод печати строки.
        for (int indentCount = 0; indentCount < indentFromLeft; indentCount++) {      // Цикл печати отступа.
            System.out.print(" ");
        }
        for (int bottomLineCount = 0; bottomLineCount < baseLineTriangle; bottomLineCount++) {    // Печать основания треугольника.
            System.out.print("*");
        }
        System.out.println();
    }
}
