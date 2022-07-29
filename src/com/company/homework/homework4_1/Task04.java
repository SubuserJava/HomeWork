package com.company.homework.homework4_1;

public class Task04 {                                // Деление числа из диапазона на множители. numIndex - предполагаемые множители числа.

    public static void main(String[] args) {

        for (int unicNumber = 1; unicNumber < 1_000_000; unicNumber++) {       // Цикл для получения числа из диапазона от 1 до 1_000_000

            int perfectNumbers = 0;                                      // Переменная для суммы множителей обнуление перед каждой проверкой числа на множители.
            for (int numIndex = unicNumber; numIndex > 0; numIndex--) {  // Цикл проверки множителей полученного числа из диапазона.
                if ((unicNumber % numIndex) == 0) {          // Проверка, тождественен ли остаток нулю от деления числа на искомый множитель. Если тождественен 0, то множитель подходит.
                    perfectNumbers = perfectNumbers + numIndex;        // Суммирование множителей.
                }
            }
            if (perfectNumbers == unicNumber * 2) {              // Проверка суммы по стандартному правилу совершенных чисел: сумма множителей должна быть тождественна числу * 2).
                System.out.println(unicNumber);        // 6 28 496 8128
            }
        }
    }
}
