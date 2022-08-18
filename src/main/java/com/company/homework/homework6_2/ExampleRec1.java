package com.company.homework.homework6_2;

public class ExampleRec1 {

    public static void main(String[] args) {

        System.out.println(printString(1234));

    }

    public static String printString(int a) {
        return printString(a / 10);
    }
}
