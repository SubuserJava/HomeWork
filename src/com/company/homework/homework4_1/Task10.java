package com.company.homework.homework4_1;

public class Task10 {

    public static void main(String[] args) {

        for (int unicNumber = 1; unicNumber < Integer.MAX_VALUE; unicNumber++) {    // Определяем для расчёта диапазон от 1 до
            boolean varCheck = false;                                               // максимального значения типа переменной int.
            for (int delimiter = 1; delimiter < 21; delimiter++) {                  // Проверяем на делимость  от 1 до 20 без остатка в цикле.
                if (unicNumber % delimiter == 0) {                                  // Проверка делимости по остатку деления по модулю.
                    varCheck = true;
                } else {
                    varCheck = false;
                    break;
                }
            }
            if (varCheck) {                                     // Проверка и выход из цикла при нахождении минимального числа.
                System.out.println(unicNumber); // 232792560
                break;
            }
        }
    }
}
