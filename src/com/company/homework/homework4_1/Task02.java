package com.company.homework.homework4_1;

public class Task02 {

    public static void main(String[] args) {                 // Вывод простых чисел от 2 до 1000000.

        System.out.println("Prime number from range from 2 to up 1000000:");

        for (int numberPrimeRange = 2; numberPrimeRange <= 100_000; numberPrimeRange++) { // Общий цикл перебора от 2 до 1000000.
            boolean VariableInterrupt = true;
            for (int RangeOfDivisior = 2; RangeOfDivisior < numberPrimeRange / 2 + 1; RangeOfDivisior++) { // Цикл нахождение делителя от 2 до проверяемого числа.
                if ((numberPrimeRange % RangeOfDivisior) == 0) {                       // Если делитель есть, значит число составное.
                    VariableInterrupt = false;
                    break;                                      // Возврат из цикла проверяющего наличие делителя.
                }
            }
            if (VariableInterrupt) {  // Вывод простого числа в зависимости от проверки возвращённого значения из вложенного цикла нахождения делителя
                System.out.println(numberPrimeRange);  // 2 3 5 7 11 13 17 .......
            }
        }
    }
}


