package com.company.homework.homework7_1.Task04;

public class Main {

    public static void main(String[] args) {

        MainString testString0 = new MainString();
        MainString testString1 = new MainString("ABCabc");
        MainString testString2 = new MainString('H');
        MainString testString3 = new MainString("abcdefgh");

        System.out.println(testString0.getLengthOfString());     // 0

        for (char c : testString1.charArray) {                   // A B C a b c}
            System.out.print(c + " ");
        }

        System.out.println();
        System.out.println(testString2.charArray[0]);            // H
        System.out.println("Length of string of second object: " + testString1.getLengthOfString());   // 6

        testString1.makeStringEmpty(testString1.charArray);      // передача в метод заполненния массива пустыми символами.
        for (char c : testString1.charArray) {
            System.out.print(c + " ");                           //              вывод пустых символов.
        }
        System.out.println();

        testString3.findCharacter('c');                  // Character found.

    }
}
