package com.company.homework.homework5_1;

import java.util.Scanner;

public class Task01 {

    public static void main(String[] args) {

        Scanner consoleInput = new Scanner(System.in);
        System.out.print("Print something phrase in latin for checking matches: ");
        String inputText = consoleInput.nextLine();
        System.out.print("Enter character for checking matches: ");
        String inputCharString = consoleInput.nextLine();
        char inputChar = inputCharString.charAt(0);

        int matchesCount = 0;
        System.out.print("Match index value: ");
        for (int a = 0; a < inputText.length(); a++) {             // Цикл проверки фразы на совпадение.
            if (inputChar == inputText.charAt(a)) {      // Сравнение символа с каждым символом строки.
                matchesCount++;                                      // Счётчик совпадений
                System.out.print(a + " ");     // Вывод индекса совпадения (текущее значения шага цикла).
            }
        }
        if (matchesCount == 0) {
            System.out.println("No matches found");
        } else {
            System.out.println("\nTotal count of match: " + matchesCount);
        }
    }
}
