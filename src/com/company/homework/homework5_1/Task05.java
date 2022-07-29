package com.company.homework.homework5_1;

import java.util.Scanner;

public class Task05 {

    public static void main(String[] args) {

        Scanner consoleInput = new Scanner(System.in);                           // Ввод текста.
        System.out.print("Enter any sentence.\n" +
                "Sentence: ");
        String inputSentence = consoleInput.nextLine();

        String[] wordsFromSentenceArray = inputSentence.split("(?U)\\W+"); // Разбивка строки на слова и заполнение массива только словами.

        int totalCountWords = 0;                                                 // Счётчик слов
        for (int stringCountCycle = 0; stringCountCycle < wordsFromSentenceArray.length; stringCountCycle++) {
            String tempWord = wordsFromSentenceArray[stringCountCycle];   // Текущее слово из массива.
            if (tempWord.length() % 2 == 0) {                             // Проверка слова на чётное кол-во букв.
                totalCountWords++;                                        // Подсчёт.
            }
        }
        System.out.println("Total number of words with an even number of letters is: " + totalCountWords);
    }
}
