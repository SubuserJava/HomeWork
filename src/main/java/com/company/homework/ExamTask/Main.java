package com.company.homework.ExamTask;

import java.io.File;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

public class Main {

    private static final File financialPath = new File("c:/financial");
    private static final File profileUserFile = new File("C:/financial/profileUserFile.ser");
    private static final File creditCardFile = new File("C:/financial/creditCardFile.ser");
    private static final File currentIncomeFile = new File("C:/financial/currentIncomeFile.ser");
    private static final File debitCardFile = new File("C:/financial/debitCardFile.ser");
    private static final File plannedCostsFile = new File("C:/financial/plannedCostsFile.ser");
    private static final File plannedIncomeFile = new File("C:/financial/plannedIncomeFile.ser");
    private static final File walletFile = new File("C:/financial/walletFile.ser");
    private static final File bankingAssetsFile = new File("C:/financial/bankingAssetsFile.ser");
    private static final File cashAssetsFile = new File("C:/financial/cashAssetsFile.ser");


    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        UserProfile userProfile = new UserProfile("Petrov Petr Petrovich", LocalDate.of(1990, 3, 12), "+79219406233");

        System.out.println(userProfile);

        System.out.println("""
                1. Показать список кошельков.
                2. Показать список карт.
                3. Показать список планируемых затрат.
                4. Показать список планируемых поступлений.
                5. 
                """);
    }
}
