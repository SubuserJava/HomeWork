package com.company.homework.homework4_1;

public class Task01 {

    public static void main(String[] args) {              // Числа Фибоначчи.

        int fibonacciNumber1 = 0;
        int fibonacciNumber2 = 1;
        int fibonacciNumber = 0;             // Переменная используется несколько раз.

        System.out.println("Fibonacci number: " + fibonacciNumber); // Вывод нуля (первого числа Фибоначчи).

        for (int count = 0; ; ){                                   // Вычисление и вывод в консоль чисел Фибоначчи больше нуля до 10000000.
            fibonacciNumber = fibonacciNumber1 + fibonacciNumber2;  // Каждое последующее число равно сумме двух предыдущих.
            if (fibonacciNumber > 10_000_000){                      // Прерывание цикла именно до печати. Что бы не распечатывалось число больше 10_000_000.
                break;
            }
            System.out.println("Fibonacci number: " + fibonacciNumber);  // 1 2 3 5 8 13 21 .... 9227465
            fibonacciNumber1 = fibonacciNumber2;   // Переопределение переменных.
            fibonacciNumber2 = fibonacciNumber;
        }
    }
}

