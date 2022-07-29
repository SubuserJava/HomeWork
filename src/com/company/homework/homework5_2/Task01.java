package com.company.homework.homework5_2;

public class Task01 {

    public static void main(String[] args) {

        int[] fibonacciNumbersArray = new int[15];
        fibonacciNumbersArray[0] = 0;                // Присваивание первому элементу нуля.

        int firstNumber = 0;
        int secondNumber = 1;
        int fibonacciNumber;
        for (int countArray = 1; countArray < 15; countArray++) {
            fibonacciNumber = firstNumber + secondNumber;               // Каждое последующее число равно сумме двух предыдущих.
            fibonacciNumbersArray[countArray] = fibonacciNumber;     // Заполнение массива числами Фибоначчи подряд.

            firstNumber = secondNumber;           // Переопределение переменных.
            secondNumber = fibonacciNumber;
        }

        for (int arrayElements : fibonacciNumbersArray) {           // Вывод только чётных чисел.
            if (arrayElements % 2 == 0 )
                System.out.print(arrayElements + " ");     // 0 2 8 34 144 610
        }
    }
}
