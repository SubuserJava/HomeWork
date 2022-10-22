package com.company.homework.homework5_1;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Task04 {

    public static void main(String[] args) {    // UnsupportedEncodingException - у меня в консоли не печатается кириллица.
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));      // Решение применимо и к кирилице.

        Scanner consoleInput = new Scanner(System.in);                                   // Ввод текста.
        System.out.print("Enter any sentence on Russian or English.\n" +
                "Sentence: ");
        String inputSentence = consoleInput.nextLine();

        inputSentence = inputSentence.replaceAll("(?U)\\W+\\s*", " "); // Очистка строки. Только буквы.
        String[] wordsFromSentenceArray = inputSentence.split(" "); // Рразбивка подготовленной строки на слова и заполнение массива словами. Такс только кирилица или латиница

        if (getSentenceType(inputSentence.charAt(0)).equals("d") | getSentenceType(inputSentence.charAt(0)).equals("u")) {  // Блок проверки предложения циры и символы, кириллицу и латиницу.
            System.out.println("Please, restart program and enter sentence made up from words.");
        } else if ((getSentenceType(inputSentence.charAt(0)).equals("c"))) {
            checkCyrillicWords(wordsFromSentenceArray);
        } else if (getSentenceType(inputSentence.charAt(0)).equals("l")) {
            checkLatinWords(wordsFromSentenceArray);
        }
    }

    private static String getSentenceType(char charFromSentence) {   // Метод проверки на буквы lat or cyr алфавита "подсмотрел" в интернете.
        if (Character.isDigit(charFromSentence)) {
            return "d";         // digital
        } else if (Character.isAlphabetic(charFromSentence)) {
            if (Character.UnicodeBlock.of(charFromSentence).equals(Character.UnicodeBlock.CYRILLIC)) {
                return "c";    // cyrillic
            } else if (Character.UnicodeBlock.of(charFromSentence).equals(Character.UnicodeBlock.BASIC_LATIN)) {
                return "l";    // latin
            }
        }
        return "u"; // Unknown тип символа.
    }

    private static void checkCyrillicWords(String[] wordsFromSentenceArray) {        // Метод проверки слов кириллицы
        System.out.print("Words that start with a vowel and end with a consonant:\n");
        int countWords = 0;
        for (String currentWord : wordsFromSentenceArray) {
            if (currentWord.matches("^[аеёоуиыеёэюяАЕЁОУИЫЁЭЮЯ].*[бвгджзйклмнпрстфхцчшщьъБВГДЖЗЙКЛМНПРСТФХЦЧШЩЬЪ]$")) {
                System.out.println(currentWord);
                countWords++;
            }
        }
        if (countWords == 0) {
            System.out.println("No that words.");
        }
    }

    private static void checkLatinWords(String[] wordsFromSentenceArray) {            // Метод проверки слов латиницы по аналогии с кирилицей.
        System.out.print("Words that start with a vowel and end with a consonant:\n");
        int countWords = 0;
        for (String currentWord : wordsFromSentenceArray) {
            if (currentWord.matches("^[aeiouyAEIOUY].*[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXZ]$")) {
                System.out.println(currentWord);
                countWords++;
            }
        }
        if (countWords == 0) {
            System.out.println("No that words.");
        }
    }
}


