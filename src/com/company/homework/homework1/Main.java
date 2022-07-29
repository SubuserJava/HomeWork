package com.company.homework.homework1;

public class Main {

    public static void main(String[] args) {
        /*
        Пример различных типов данных и операций с ними
        */

        byte a = 100;
        a = (byte) -a;
        short b = -32768;
        int c = a * b * -327; // Автоматическое приведение к общему типу данных int переменных a и b
        long d = (320000 * 24) + (123456789 / -2) - ((long) c * (long) c);
        float e = 1.6666f / b;
        double f = 123.456452134567895462456892 / -3 * 100;
        char g = '\u0054', h = 'Y', i = '\u0050', j = 'E';
        boolean k = false, l = true;

        if(b > a) {
            l = false;
        }

        System.out.println("Значение пераменной a: " + a);
        System.out.println("значение переменной b: " + (a + b));
        System.out.println("значение переменной c: " + c);
        System.out.println("значение переменной d: " + d);
        System.out.println("значение переменной e: " + e);
        System.out.println("значение переменной f: " + f);
        System.out.println("значение переменной g, h, i, j - вывод в консоль слова: " + g + h + i +j);

        if(k == l) {
            System.out.println("значение переменной k: " + k + " и переменной l: " + l);
        }
    }
}
