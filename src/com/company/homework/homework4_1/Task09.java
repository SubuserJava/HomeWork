package com.company.homework.homework4_1;

public class Task09 {

    public static void main(String[] args) {

        int sumNums = 0;
        for (int number = 0; number <= 1000; number++) {      // Цикл от 0 до 1000
            if (((number % 3) == 0) | ((number % 5) == 0)) {  // Проверка числа одновременно на кратность 3 или 5, согласно условию задачи.
                sumNums += number;
            }
        }
        System.out.println("The total sum of multiples of 3 and 5 is " + sumNums + ".");   // 234168
    }
}
