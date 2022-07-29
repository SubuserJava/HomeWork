package com.company.homework.homework4_1;

public class Main {

    public static void main(String[] args) {

        float a = 100;
        float b = 25;
        float c;

        if ((c = ((a / b) * b + (a % b))) == a) {
            System.out.println("1: " + c);
        } else {
            System.out.println("2: " + c);


        }
        System.out.println(Math.ceil(Math.sqrt(5)));
    }
}
