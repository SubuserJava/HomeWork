package com.company.homework.homework4_1;

public class Task03 {

    public static void main(String[] args) {    // Числа Армстронга.
        // Блок вычисления чисел Армстронга и вывод в консоль
        for (int numArmstrong = 10; numArmstrong <= 1_000_000; numArmstrong++) { // цикл на получение переменной с числами от 10 до 1_000_000.

            String stringInputNum = String.valueOf(numArmstrong);    // Перевод числа в строку.
            char[] charArrayNumsFromString = stringInputNum.toCharArray();  // Заполнение массива char символами числа.

            int powerOfNumArmstrong = stringInputNum.length();          // Длина строки. Это же степепнь для возведения чисел в будущем.
            int sumNumsOfArray = 0;
            for (int index = 0; index < powerOfNumArmstrong; index++) {  // Цикл для суммирования возведённых в полученную степень чисел из массива.
                sumNumsOfArray = (int) (sumNumsOfArray + Math.pow(Integer.parseInt(String.valueOf(charArrayNumsFromString[index])), powerOfNumArmstrong));
            }

            if (sumNumsOfArray == numArmstrong) {     // Проверка на равенство по правилу чисел Армстронга.
                System.out.println(numArmstrong);   // 153 370 371 407 1634 8208 ...
            }
        }
    }
}
