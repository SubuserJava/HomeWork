package com.company.homework.homework4_1;

public class Task11 {

    public static void main(String[] args) {  // 3 - fizz, 5 - buzz, 15 - hiss Число может быть одновременно кратным 3,5,15

        for (int unicNumber = 1; unicNumber < 1000; unicNumber++) {      // цикл для чисел от 1 до 1000
            if (unicNumber % 3 == 0) {                                   // Проверка на кратность 3-м.
                System.out.println(" fizz");
                if (unicNumber % 5 == 0) {                               // На кратность 5-ти.
                    System.out.println(" buzz");
                    if (unicNumber % 15 == 0) {                          // На кратность 15-м.
                        System.out.println(" hiss");
                    }
                }                                   // Т.к. число может быть кратно 3,5 и 15 одновременно, проверки вложенные.
            } else {                                // Вывод соответствующих значений вместе с проверками.
                System.out.println(unicNumber);            // Вывод остальных чисел после else из первой проверки.
            }
        }
    }
}