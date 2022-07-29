package com.company.homework.homework4_2;

import java.util.Scanner;

public class Task02 {

    public static void main(String[] args) {

        Scanner consoleSystemIn = new Scanner(System.in);           // Блок ввода значений треугольника. Минимум 3.
        System.out.print("Enter the once height and length (not more less 2) )of the triangle not more less 3.\n" +
                "Value height and length once - ");
        int heightLengthTriangle = consoleSystemIn.nextInt();
        System.out.print("Enter '1' if the triangle is full and '0' if the triangle is empty.\n" +
                "Value full or empty - ");
        int valueFullEmpty = consoleSystemIn.nextInt();
        System.out.println();

        printTriangleFullEmpty(heightLengthTriangle, valueFullEmpty);
    }

    private static void printTriangleFullEmpty(int heightLengthTriangle, int valueFullEmpty) {   // Метод с двумя переменными высота треугольника и пустой/заполненный.

        for (int firstLineCount = 0; firstLineCount < heightLengthTriangle; firstLineCount++) {    // Цикл печати первой строки символами '*'.
            System.out.print("*");
        }
        System.out.println();                                  // Возврат пустой строки.

        int arg1 = 2;                                              // Управляющий оператор цикла печати перед наклонной линией. Начальное значение 2, т.к. пробелов не может быть < 1-ого.
        int arg2 = heightLengthTriangle;                           // Управляющий оператор цикла печати после наклонной линии.
        for (int middlePartCount = 0; middlePartCount < heightLengthTriangle - 2; middlePartCount++) {    // Общий цикл количества строк между первой и последней строкой
            for (int leftIndentCount = 1; leftIndentCount < arg1; leftIndentCount++) {    // Вложенный цикл печати пробелов перед наклонной линией. Управляющий оператор arg1 увеличивается на 1 с каждым шагом, начиная с 2.
                System.out.print(" ");                   // На новой строке печтается на 1 пробел больше. Цикл вложенный, кол-во раз цикла ограничивается кол-м первого цикла (кол-м строк)
            }
            arg1++;
            System.out.print("*");                                 // Печать '*' после цикла пробелов перед "наклонной линией". Печать "наклонной" линии.

            for (int innerPartCount = arg2 - 3; innerPartCount > 0; innerPartCount--) { // Цикл печати символов серединной части после символа '*' левой линии. Оператор управления циклом arg2 уменьшается на 1 с каждым шагом
                if (valueFullEmpty == 0) {                    // Проверка печати "пустой", "полный" треугольник.
                    System.out.print(" ");                            // Печать пробелов в случае "пустой" треугольник.
                } else {
                    System.out.print("*");                            // и '*' в случае "полный".
                }
            }
            arg2--;
            System.out.println("*");                              // Печать символа '*' в конце каждой строки.
        }

        for (int bottomLineCount = 0; bottomLineCount < heightLengthTriangle - 1; bottomLineCount++) {      // Цикл печати последней строки пробелами.
            System.out.print(" ");
            if (bottomLineCount == heightLengthTriangle - 2) {                        // Печать последнего символа '*' в последней строке.
                System.out.print("*");
            }
        }
        System.out.println();
    }
}

