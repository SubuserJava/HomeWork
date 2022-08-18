package com.company.homework.homework6_2;

import java.util.Scanner;

public class Task03 {

    public static void main(String[] args) {

        Scanner consoleInput = new Scanner(System.in);
        System.out.print("Enter any number.\n" +
                "Number N: ");
        calcSumNumbersOfValue(consoleInput.nextDouble(), 0d, 10d);
    }

    private static void calcSumNumbersOfValue(double inputNumber, double sumNumbers, double controlDelimiter) {

        sumNumbers += inputNumber % controlDelimiter / controlDelimiter * 10;       // Вычисление десятков, сотен, тысяч и т.д. и суммирование.
        if (inputNumber == 0) {                                                    // Проверка числа на 0 для выхода из рекурсии и вывод результата
            System.out.print("The sum of numbers from value is " + (int) sumNumbers);
            return;
        }
        calcSumNumbersOfValue(inputNumber - inputNumber % controlDelimiter, sumNumbers, controlDelimiter *= 10);
    }   // Передача в рекурсивный метод: 1.Уменьшение числа на вычисленную часть. 2.Увеличение делителя на следующую разрядность.
}

//    public static void main(String[] args) {    // Нашёл в интернте способ интереснее. Копировать не хочу. Способ применим ко следующим задачам.
//                                                   Это для вывода цифр. Суммирование добавить не сложно.
////        printNumber(12345);
//    }
//
//    public static void printNumber(int number) {
//        if (number == 0) {
//            return;
//        }
//        System.out.println(number % 10);
//        printNumber(number / 10);
//    }
//}




