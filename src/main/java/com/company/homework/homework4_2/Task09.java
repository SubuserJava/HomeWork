package com.company.homework.homework4_2;

import java.util.Scanner;

public class Task09 {

    public static void main(String[] args) {

        Scanner consoleSystemIn = new Scanner(System.in);
        System.out.print("Enter the number of tiers, the height of the first tier and indent from left separated by a space.\n" +
                "Value: ");
        String input = consoleSystemIn.nextLine();
        String[] inputStringArray = input.split(" ");

        int tiersCount = Integer.parseInt(inputStringArray[0]);        // Считывание переменных из строки.
        int heightFirstTier = Integer.parseInt(inputStringArray[1]);
        int indentLeft = Integer.parseInt(inputStringArray[2]);
        int shiftIndent = ((heightFirstTier + tiersCount) * 2 - 1) / 2; // Значение сдвига в зависимости от кол-ва ярусов.

        for (int cycleTiersCount = 0; cycleTiersCount < tiersCount; cycleTiersCount++) {                                 // Цикл общего количества ярусов
            int shiftTiersSymbols = 1;                       // Переменная управления кол-ом циклов мдля начального количества * в ярусе.
            int shiftIndentTemp = shiftIndent;               // Переменная управления кол-м циклов печати отступа слева. С каждым циклом печати яруса значение возвращается к начальному.
            for (int lineTierCount = 0; lineTierCount < heightFirstTier; lineTierCount++) {                  // Цикл печати строк яруса.
                for (int cycleIndentFromLeft = 0; cycleIndentFromLeft < shiftIndentTemp + indentLeft; cycleIndentFromLeft++) {   // Цикл печати пробелов для отступа слева
                    System.out.print(" ");
                }
                for (int cycleTiersSymbols = 0; cycleTiersSymbols < shiftTiersSymbols; cycleTiersSymbols++) {                // Цикл печати символов яруса.
                    System.out.print("*");
                }
                System.out.println();
                shiftIndentTemp -= 1;    // Отступ слева уменьшается с каждой строкой на 1.
                shiftTiersSymbols += 2;  // Количество * с каждой строкой увеличивается на 2.
            }
            heightFirstTier += 1;        // Увеличение высоты яруса с каждым шагом (кол-во ярусов).
        }
    }
}

