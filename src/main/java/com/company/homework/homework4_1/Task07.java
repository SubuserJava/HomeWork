package com.company.homework.homework4_1;

public class Task07 {

    public static void main(String[] args) {

        int decimalInteger = 481;                       // Дано некое число, тип переменной - integer. 9 разрядов в двоичной системе.
        System.out.print("Decimal view number - " + decimalInteger + "\n" +
                "Binary view number - ");

        for(int index = 9; index > 0; index--) {                // Цикл для вывода числа в бинарном виде.
           int binaryViewNum = (decimalInteger >> (index - 1)) % 2; // Побитовый сдвиг на (разряд - 1), деление на 2 по модулю, присваивание остатка переменной.
            System.out.print(binaryViewNum);                     // 111100001 Вывод в консоль текущего знач. остатка от деления по модулю.
        }
    }
}
