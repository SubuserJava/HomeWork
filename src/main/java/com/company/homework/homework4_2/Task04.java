package com.company.homework.homework4_2;

import java.util.Scanner;

public class Task04 {               // Печать разбивается на 4 части. 1 - верхняя и нижняя *. 2 - серединная часть верхней части ромба.
    // 3 - средняя линия. 4 - Нижняя средняя часть.
    public static void main(String[] args) {

        Scanner consoleSystemIn = new Scanner(System.in);
        System.out.print("Enter the height (odd number for symmetry and not more less 3) in string of the rhombus.\n" +
                "Full or empty interior of the rhombus.\n" +
                "Indent from the left side.\n");
        int rhombusHeight;
        do {
            System.out.print("\nValue height (odd). if the number is not odd then it will be reduced by 1 - ");
            rhombusHeight = consoleSystemIn.nextInt();
            if (rhombusHeight < 3) {      // Высота должна быть не менее 3.
                System.out.println("You entered too small the value height. Enter again, please.");
            }
        } while (rhombusHeight < 3);

        if (rhombusHeight % 2 == 0) {     // Если высота чётная, то минус 1. Чтобы стала нечётной.
            rhombusHeight -= 1;
        }
        System.out.print("Enter '1' if the triangle is full and '0' if the triangle is empty.\n" +
                "Value full or empty - ");
        int fillEmptyRhombus = consoleSystemIn.nextInt();
        System.out.print("Value indent - ");
        int indentLeft = consoleSystemIn.nextInt();
        System.out.println();

        printTopBottomString(rhombusHeight, indentLeft);             // Метод для печати первой строки ромба с одной *.
        printHighMiddle(rhombusHeight, indentLeft, fillEmptyRhombus);   // Метод для печати средней части "верхнего" сегмента ромба
        printMiddleString(rhombusHeight, indentLeft, fillEmptyRhombus); // Метод для печати серединной линии ромба.
        printLowerMiddle(rhombusHeight, indentLeft, fillEmptyRhombus);  // Метод для печати средней части "нижнего" сегмента ромба.
        printTopBottomString(rhombusHeight, indentLeft);             // Метод для печати последней строки (метод одинаков для печати верхней строки).
    }

    private static void printTopBottomString(int rhombusHeight, int indentLeft) {   // Метод печати первой и последней строки.
        for (int indentCount = 0; indentCount < ((rhombusHeight - 1) / 2) + indentLeft; indentCount++) {    // Учитывается отступ indentLeft.
            System.out.print(" ");
        }
        System.out.println("*");
    }

    private static void printMiddleString(int rhombusHeight, int indentLeft, int fillEmptyRhombus) { // Печать серединной строки
        for (int indentCount = 0; indentCount < indentLeft; indentCount++) {                         // Цикл печати отступа слева.
            System.out.print(" ");
        }
        System.out.print("*");           // Печать первого символа "*".

        for (int innerPartLine = 0; innerPartLine < rhombusHeight - 2; innerPartLine++) {    // Цикл печати внутренней части средней линии ромба.
            if (fillEmptyRhombus == 1) {
                System.out.print("*");   // Печать "*" в случае полный.
            } else {
                System.out.print(" ");   // Печать " " в случае пустой.
            }
        }
        System.out.print("*");           // Печать последнего символа "*".
        System.out.println();
    }

    private static void printHighMiddle(int rhombusHeight, int indentLeft, int fillEmptyRhombus) {  // Метод печати верхней середины.
        int arg1 = rhombusHeight / 2 - 1;             // Переменные управляющие циклами.
        int arg2 = arg1 + indentLeft;                 // Переменная управления цикла печати отступа слева с учётом общего отступа.
        int arg3 = 1;                                 // Переменная управления циклом печати в середине строки.
        for (int lineCount = 0; lineCount < arg1; lineCount++) {          // Общий цикл печати строк в середине верхней части ромба.
            for (int indentLeftCount = 0; indentLeftCount < arg2; indentLeftCount++) {      // Цикл печати символов до левой линии.
                System.out.print(" ");
            }
            arg2--;                          // Переменная управления циклом печати символов до левой боковой линии.
            System.out.print("*");                       // Печать символа "*" в начале строки после пробелов слева

            for (int innerCount = 0; innerCount < arg3; innerCount++) {  // Цикл печати символов внутри ромба. Пустой или полный
                if (fillEmptyRhombus == 1) {               // Проверка пустой / полный ромб.
                    System.out.print("*");                 // Печать "запоолненного" ромба.
                } else {
                    System.out.print(" ");                 // Печать "пустого" ромба.
                }
            }
            arg3 += 2;             // Приращение упр. переменной на 2 позиции. т.к. на каждой новой строчке увеличение на 2 символа.
            System.out.print("*"); // Символ "*" в конце строки.
            System.out.println();  // Перевод строки.
        }
    }

    private static void printLowerMiddle(int rhombusHeight, int indentLeft, int fillEmptyRhombus) {
        int arg1 = rhombusHeight / 2 - 1;                  // Переменные управления циклами.
        int arg2 = 1 + indentLeft;                                  // Переменная управления циклом печати " " до левой линии.
        int arg3 = rhombusHeight - 4; // Переменная управления циклом печати между линиями. Начало - меньше общей длины ромба на 4
        for (int lineCount = 0; lineCount < arg1; lineCount++) {          // Общий цикл печати строк в середине верхней части ромба.
            for (int leftStarCount = 0; leftStarCount < arg2; leftStarCount++) {      // Цикл печати символов " " до левой линии.
                System.out.print(" ");
            }
            arg2 += 1;                          // Переменная управления циклом печати символов до левой боковой линии.
            System.out.print("*");                       // Печать символа "*" в начале строки после пробелов

            for (int innerCount = 0; innerCount < arg3; innerCount++) {  // Цикл печати символов внутри ромба. Пустой или полный.
                if (fillEmptyRhombus == 1) {               // Проверка печати пустой/полный ромб.
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            arg3 -= 2;             // Приращение упр. переменной на 2 позиции. т.к. на каждой новой строчке увеличение на 2 символа.
            System.out.print("*"); // Символ "*" в конце строки.
            System.out.println();  // Перевод строки.
        }
    }
}


