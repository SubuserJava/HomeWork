package com.company.homework.homework6_2;

public class Task07 {

    public static void main(String[] args) {

        String stringSentence = "enter abba yes now radar level find";
        System.out.println(stringSentence);
        String[] tempSentenceArray = stringSentence.split(" ");

        for (String tempWord : tempSentenceArray) {   // передача в метод слов на проверку.
            int countStart = 0;
            int countEnd = tempWord.length() - 1;
            printCheckResult(tempWord, countStart, countEnd);   // no yes no no yes yes no
        }
    }

    private static void printCheckResult(String tempWord, int countStart, int countEnd) {
        if (countStart == (tempWord.length() - 1) / 2) {                   // Проверка позиции символа в слове, проверка применима как к словам
            System.out.print("yes ");                                    // с нечётным кол-ом букв, так и с чётным.
            return;
        }
        if (tempWord.charAt(countStart) != tempWord.charAt(countEnd)) {   // Сравнение символов. Если хоть одно несовпадение - прерывание, "no".
            System.out.print("no ");
            return;
        }
        printCheckResult(tempWord, ++countStart, --countEnd);       // Рекурсивный вызов метода с увеличивающимися счётчиками.
    }
}
