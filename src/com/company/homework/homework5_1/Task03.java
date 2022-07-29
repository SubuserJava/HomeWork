package com.company.homework.homework5_1;

import java.util.Scanner;

public class Task03 {

       public static void main(String[] args) {

        Scanner consoleInput = new Scanner(System.in);
        System.out.print("Enter any sentence with dot in the end.\n" +
                "Phrase: ");
        StringBuilder inputPhrase = new StringBuilder(consoleInput.nextLine());

        if (inputPhrase.lastIndexOf(".") == -1) {
            System.out.println("Sorry, you entered phrase without dot on the end. Run the program again.");
            return;
        }

        int wordCount = 0;     // Счётчики.
        int lettersCount = 0;
        for (int b = 1; ; b++) {
            if (String.valueOf(inputPhrase.charAt(0)).equals(" ")) {   // Проверка первого символа строки на пробел
                wordCount++;                                           // Если пробел, то счётчик кол-ва слов + 1.
                inputPhrase.delete(0, 1);       // Уменьшение строки с каждым шагом цикла на символ с начала строки.
            } else {
                inputPhrase.delete(0, 1);       // Уменьшение строки с каждым шагом цикла на символ с начала строки.
                lettersCount++;                 // Счётчик кол-ва букв.
            }
            if (String.valueOf(inputPhrase.charAt(0)).equals(".")) {        // Цикл бесконечный, если точка - выход.
                wordCount++;
                break;
            }
        }
        System.out.println("Number of words in the sentence is " + wordCount + ". Average number of characters per word is " + lettersCount / wordCount + ".");
    }
}
