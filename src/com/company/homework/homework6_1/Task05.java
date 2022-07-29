package com.company.homework.homework6_1;

import java.util.Scanner;

public class Task05 {

    public static void main(String[] args) {

        Scanner consoleInput = new Scanner(System.in);
        System.out.println("Enter values to calculate dragon fight.");
        System.out.print("Value lives of Dragon: ");
        int powerOfDragon = consoleInput.nextInt();                // Сила дракона.
        System.out.print("Value of Dragon attack: ");
        int attackOfDragon = consoleInput.nextInt();                // Атака дракона.
        System.out.print("Health of spearman: ");
        int powerOfSpearmen = consoleInput.nextInt();                // Кол-во жизней (сила) одного копейщика.
        System.out.print("Value of spearmen attack: ");
        int attackOfSpearmen = consoleInput.nextInt();                // Атака одного копейщика.
        System.out.print("Number of estimated spearmen: ");
        int countOfSpearmen = consoleInput.nextInt();                // Оцениваемое кол-во копейщиков.
        int totalHealthSpearmens = countOfSpearmen * powerOfSpearmen;       // Общее здорвье копейщиков.
        int healthOfWounded = 0;
        System.out.println();

        for (; ; ) {     // Бесконечный цикл атак и подсчёта атак.
            if (powerOfDragon - (countOfSpearmen * attackOfSpearmen) <= 0) {      // Если атака копейщиков приведёт к тому, что здоровье дракона <= 0, победа копейщиков
                printLogAttackWinSpearmen(powerOfDragon, countOfSpearmen);
                break;
            } else if ((totalHealthSpearmens - attackOfDragon) <= 0) {        // Если дракон атакует и общее здоровье копейщиков <= 0, то победа дракона.
                printLogAttackWinDragon(powerOfDragon, totalHealthSpearmens);
                break;
            }
            // Атака копейщиков. здоровье дракона минус кол-во коп. * на атаку коп.
            powerOfDragon -= attackOfSpearmen * countOfSpearmen;
            printLogAttackOfSpearmen(powerOfDragon, countOfSpearmen, powerOfSpearmen);             // Печать лога атаки копейщиков.

            // Атака дракона
            if (attackOfDragon % powerOfSpearmen == 0) {                                           // Если атака дракона не оставляет остаток, то...
                totalHealthSpearmens -= attackOfDragon;
                countOfSpearmen = totalHealthSpearmens / powerOfSpearmen;                          // Атака дракона. Подсчёт уменьшения кол-ва копейщиков.
                printLogAttackOfDragon(countOfSpearmen);
            } else {
                totalHealthSpearmens -= attackOfDragon;
                healthOfWounded += attackOfDragon % powerOfSpearmen;                // Увеличиваем значение здоровья "раненного" на остаток от атаки дракона.
                if (healthOfWounded >= powerOfSpearmen) {                           // Если здоровье раненного >= сила одного копейщика, то
                    healthOfWounded -= powerOfSpearmen;                             // уменьшаем её на силу одного, оставляя остаток.
                    totalHealthSpearmens += healthOfWounded;
                    countOfSpearmen = totalHealthSpearmens / powerOfSpearmen + 2;   // Добавляем к общему кол-ву копейщиков результат "появления" жизни от раненного.
                } else {
                    countOfSpearmen = totalHealthSpearmens / powerOfSpearmen + 1;       // Подсчитываем общее кол-во копейщиков, если "жизнь" раненного не перешла к общему кол-ву.
                }

                printLogAttackOfDragon(countOfSpearmen, healthOfWounded);
            }
        }
    }

    private static void printLogAttackOfDragon(int countOfSpearmen) {
        System.out.println("Log attack of Dragon. Dragon attack, number of Spearmen left: " + countOfSpearmen + ", no wounded.");
    }

    private static void printLogAttackOfDragon(int countOfSpearmen, int healthOfWounded) {
        System.out.println("Log attack of Dragon. Dragon attack, number of Spearmen left: " + countOfSpearmen + ", one wounded, remaining lives: " +
                healthOfWounded + "\n");
    }

    private static void printLogAttackOfSpearmen(int powerOfDragon, int countOfSpearmen, int powerOfSpearmen) {    // Печать лога атаки копейщиков.
        System.out.println("Log attack of spearmen: spearmen attack, damage to Dragon: " + (powerOfSpearmen * countOfSpearmen) +
                ". The rest of the dragon's strength: " + powerOfDragon + "\n");
    }

    private static void printLogAttackWinSpearmen(int powerOfDragon, int countOfSpearmen) {
        System.out.println("Number of spearmen left is " + countOfSpearmen + " . Life of Dragon is " + powerOfDragon + " . Spearmen attack and win!");
    }

    private static void printLogAttackWinDragon(int powerOfDragon, int totalHealthSpearmens) {
        System.out.println("Total health spearmen is " + totalHealthSpearmens + " . Life of Dragon is " + powerOfDragon + " . Dragon attack and win!");
    }


}

//    private static int getTotalHealthOfSpearmen(int countOfSpearmen, int powerOfSpearmen, int totalHealthSpearmens) {
//        Task05.totalHealthSpearmens = countOfSpearmen * powerOfSpearmen;
//        return Task05.totalHealthSpearmens;
//    }
//
//    private static int getTotalHealthOfSpearmen(int countOfSpearmen, int powerOfSpearmen, int healthOfWounded, int totalHealthSpearmens) {
//        Task05.totalHealthSpearmens += countOfSpearmen * powerOfSpearmen + healthOfWounded;
//        return Task05.totalHealthSpearmens;
//    }


//    private static void getValuesIterationOfAttackDragon(int attackOfDragon, int powerOfSpearmen, int totalHealthSpearmens, int countOfSpearmen, int healthOfWounded) {
//
//        if (attackOfDragon % powerOfSpearmen == 0) {                      // Если атака дракона не оставляет остаток, то...
//            countOfSpearmen -= attackOfDragon / powerOfSpearmen;         // Стандартным вычитанием подсчитываем кол-во копейщиков.
//            totalHealthSpearmens = countOfSpearmen * powerOfSpearmen;          // Подсчёт общего количества здоровья копейщиков.
//        } else {
//            countOfSpearmen -= attackOfDragon / powerOfSpearmen;         // Если нет, то сначала отнимаем по целой части от атаки дракона некое кол-во копейщиков.
//            healthOfWounded += attackOfDragon % powerOfSpearmen;         // Увеличиваем здоровье "раненного" на остаток от атаки дракона.
//
//            totalHealthSpearmens = countOfSpearmen * powerOfSpearmen + healthOfWounded;   // Подсчитываем общее здоровье копейщиков, учитывая кол-во здоровья "раненного.
//            countOfSpearmen = totalHealthSpearmens / powerOfSpearmen;                      // Подсчитываем общее кол-во копейщиков (остаток отбрасываем, т.к. (int))
//            if (healthOfWounded >= powerOfSpearmen) {         // Если здоровье раненного >= сила одного копейщика, то
//                healthOfWounded -= powerOfSpearmen;          // уменьшаем её на силу одного.
//                countOfSpearmen += 1;                         // К общему кол-ву прибавляем 1 копейщика.
//                totalHealthSpearmens += countOfSpearmen * powerOfSpearmen + healthOfWounded;    // Ещё раз подсчитываем и переприсваиваем переменной общую силу.
//            }
//        }
//        System.out.println("Log attack of Dragon. Dragon attack, number of Spearmen left: " + countOfSpearmen + ", one wounded, remaining lives: " +
//                healthOfWounded + "\n");
//    }

