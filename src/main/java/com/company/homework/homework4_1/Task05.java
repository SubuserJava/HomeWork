package com.company.homework.homework4_1;

import java.util.Scanner;

public class Task05 {

    public static void main(String[] args) {        // Проверка чисел на палиндромность.

        Scanner consoleSystemIn = new Scanner(System.in);   // Ввод любого целого числа с консоли начиная с нуля.
        System.out.println("Enter any integer from 0");
        String enteredNum = consoleSystemIn.nextLine();
        char[] stringArray = enteredNum.toCharArray();       // Строка -> в массив символов.

        boolean variableCheck = false;                  // Объявление переменной для возврата значения из проверки числа на палиндромность.
        if (stringArray.length < 2) {                    // Проверка на однозначные числа (до 10). Все однозначные числа - палиндромы.
            System.out.println("YES");
            return;
        } else {              // Все остальные числа проверяются на тождество в цикле, управляемым по 2-м индексами, посимвольно в массиве
            int index1;       // с начала и с конца массива к середине. Переменной variableCheck присваивается соответствующее значение.
            int index2;
            for (index1 = 0, index2 = stringArray.length - 1; index1 <= index2; index1++, index2--) {
                if (stringArray[index1] == stringArray[index2]) {
                    variableCheck = true;
                } else {
                    variableCheck = false;
                    break;
                }
            }
        }
        if (variableCheck) {      // Вывод на печать "YES" - палиндром, "NO" - не палиндром в зависимости от возвращённого значения проверки
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}


