package com.company.homework.homework4_2;

import java.util.Scanner;

public class Task01 {

    public static void main(String[] args) {

        Scanner consoleSystemIn = new Scanner(System.in);           // Блок ввода значений треугольника. По условию задачи фигура должна быть ровной.
        System.out.print("Enter the height and length (not more less 2) of the triangle.\n" +       // Поэтому вторая сторона треугольника должна быть того же размера.
                "Value height and length once - ");
        int heightLengthTriangle = consoleSystemIn.nextInt();
        System.out.print("Enter '1' if the triangle is full and '0' if the triangle is empty.\n" +
                "Value full or empty - ");
        int valueFullEmpty = consoleSystemIn.nextInt();
        System.out.println();

        printTriangleFilledAndEmpty(heightLengthTriangle, valueFullEmpty);
    }

    private static void printTriangleFilledAndEmpty(int heightLengthTriangle, int valueFullEmpty) {   // Метод с двумя переменными высота треугольника и пустой/заполненный.

        for (int topLineCount = 0; topLineCount < heightLengthTriangle; topLineCount++) {          // Цикл печати первой строки пробелами.
            System.out.print(" ");
            if (topLineCount == heightLengthTriangle - 2) {                        // Печать последнего символа * в первой строке.
                System.out.print("*");
            }
        }
        System.out.println();                                  // Возврат каретки после печати первой строки.
        int arg1 = heightLengthTriangle;     // Управляющая переменная. Уменьшает каждый шаг значения количества шагов цикла при печати "наклонной" линии с правого верхнего угла в левый нижний.
        for (int innerPartCount = 0; innerPartCount < heightLengthTriangle - 2; innerPartCount++) {     // Цикл серединной части между первой и последней строками.
            for (int arg3 = 0; arg3 < arg1 - 2; arg3++) {           // Цикл для печати пробелов "снаружи" до "наклонной линии.
                System.out.print(" ");                          // Размер цикла с каждым шагом уменьшается, управляясь переменной arg1.
            }                                                   // Таким образом, получается наклонная линия
            arg1--;
            System.out.print("*");                              // Печать * в конце строки каждого уменьшающегося цикла. -> наклонная линия.

            for (int innerCount = innerPartCount + 3; innerCount > 3; innerCount--) {
                if (valueFullEmpty == 0) {                      // Проверка: печать пробела "внутри", если треугольник пустой.
                    System.out.print(" ");
                } else {                                        // Печать '*' "внутри ", если треугольник полный .
                    System.out.print("*");
                }
            }
            System.out.print("*\n");                            // Печать последнего символа '*' в строке c переводом строки
        }
        for (int bottomLineCount = 0; bottomLineCount < heightLengthTriangle; bottomLineCount++) {       // Печать последней строки символами '*'.
            System.out.print("*");
        }
        System.out.println();
    }
}
