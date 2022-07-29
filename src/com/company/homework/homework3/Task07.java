package com.company.homework.homework3;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Task07 {

    public static void main(String[] args) throws UnsupportedEncodingException {

        System.setOut(new PrintStream(System.out, true, "UTF-8"));

        String cyrillicAlphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        char[] cyrillicAlphabetArray = cyrillicAlphabet.toCharArray();                   // Задание массива символов кириллицы.;
        String latinAlphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] latinAlphabetArray = latinAlphabet.toCharArray();                         // Задание массива символов латиницы.
        char[] digitsArray = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        System.out.println("Enter any letter (cyrillic and latin) or number");    // Ввод латиницы, кирилицы, цифры или любого символа
        Scanner console = new Scanner(System.in);
        String enterFromConsole = console.nextLine();
        char enteredChar = enterFromConsole.charAt(0);

        boolean foundInCyrillicArray = false; // Назначение переменной для проверки совпадений.
        for (int a : cyrillicAlphabetArray) { // Перебор массива кирилицы для совпадения символа.
            if (a == enteredChar) {
                foundInCyrillicArray = true;  // Возввращаемое значение проверки.
                break;                        // Преравание перебора в случае совпадения символа с кирилицей..
            }
        }
        boolean foundInLatinArray = false;
        for (int b : latinAlphabetArray) {    // Тоже самое с латиницей.
            if (b == enteredChar) {
                foundInLatinArray = true;
                break;
            }
        }
        boolean foundInDigitArray = false;    // Тоже самое с цифрами.
        for (int c : digitsArray) {
            if (c == enteredChar) {
                foundInDigitArray = true;
                break;
            }
        }

        if (foundInDigitArray) {                // В зависимости от возвращённого значения, вывод, что символ - цифра.
            System.out.println("Entered symbol is digit");
        } else if (foundInCyrillicArray) { // В зависимости от возвращённого значения, вывод, что символ - кирилица
            System.out.println("Entered character " + enteredChar + " is cyrillic.");
        } else if (foundInLatinArray) {    // или латиница.
            System.out.println("Entered character " + enteredChar + "is latin.");
        } else {
            System.out.println("I can't determine the entered character");    // По остаточному принципу - не могу определить.
        }
    }
}

