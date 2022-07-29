package com.company.homework.homework5_1;

import java.util.Scanner;

public class Task10 {

    public static void main(String[] args) {

        Scanner consoleInput = new Scanner(System.in);
        System.out.println("Enter any word");
        String wordFromConsole = consoleInput.nextLine();

        int controlVar = wordFromConsole.length();
        for (int countTopLines = 0; countTopLines < wordFromConsole.length(); countTopLines++) {  // Цикл печати линий и букв в конце линии.
            for (int countSymbols = controlVar; countSymbols > 0; countSymbols--) {               // Цикл печати пробелов.
                System.out.print(" ");

            }
            controlVar--;                                                              // Переменная управляющая циклом печати пробелов.
            System.out.print(wordFromConsole.substring(0, countTopLines));             // Печать букв из слова.
            System.out.println();                                                      // Перевод строки.
        }
        System.out.println(wordFromConsole);           // Печать середины.

        for (int countBottomLine = 0; countBottomLine < wordFromConsole.length() - 1; countBottomLine++) {    // Цикл печати нижних линий.
            System.out.print(wordFromConsole.substring(countBottomLine + 1));
            System.out.println();
        }
    }
}



