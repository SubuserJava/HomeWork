package com.company.homework.homework3;

import java.util.Scanner;

public class Task05 {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);                        // Ввод даты рождения
        System.out.print("Enter date of birth in format dd mm yyyy:\n" +
                "Day: ");
        int entryDayOfBirth = console.nextInt();
        System.out.print("Month: ");
        int entryMonthOfBirth = console.nextInt();
        System.out.print("Year: ");
        int entryYearOfBirth = console.nextInt();

        String outputYear = "";
        entryYearOfBirth = entryYearOfBirth % 12;       // Вычисление года из 12-ти летней декады знаков Зодиака

        switch (entryYearOfBirth) {                     // Вывод вычисленного знака по годам.
            case 0 -> outputYear = "Monkey";
            case 1 -> outputYear = "Rooster";
            case 2 -> outputYear = "Dog";
            case 3 -> outputYear = "Pig";
            case 4 -> outputYear = "Rat";
            case 5 -> outputYear = "Bull";
            case 6 -> outputYear = "Tiger";
            case 7 -> outputYear = "Rabbit";
            case 8 -> outputYear = "Dragon";
            case 9 -> outputYear = "Snake";
            case 10 -> outputYear = "Horse";
            case 11 -> outputYear = "Goat";
        }

        String outputSignOfZodiac = "";

        switch (entryMonthOfBirth) {                                 // Вычисление месячного знака Зодиака.
            case 1:                                                  // Сдвиги по числам разные. Из-за этого
                if (entryDayOfBirth >= 1 & entryDayOfBirth <= 20) {  // части месяца для знака разные.
                    outputSignOfZodiac = "Capricorn"; // Козерог
                } else {
                    outputSignOfZodiac = "Aquarius"; // Водолей
                }
                break;
            case 2:
                if (entryDayOfBirth >= 1 & entryDayOfBirth <= 19) {
                    outputSignOfZodiac = "Aquarius"; // Козерог
                } else {
                    outputSignOfZodiac = "Pisces"; // Рыбы
                }
                break;
            case 3:
                if (entryDayOfBirth >= 1 & entryDayOfBirth <= 20) {
                    outputSignOfZodiac = "Pisces"; // Рыбы
                } else {
                    outputSignOfZodiac = "Aries"; // Овен
                }
                break;
            case 4:
                if (entryDayOfBirth >= 1 & entryDayOfBirth <= 20) {
                    outputSignOfZodiac = "Aries"; // Овен
                } else {
                    outputSignOfZodiac = "Taurus"; // Телец
                }
                break;
            case 5:
                if (entryDayOfBirth >= 1 & entryDayOfBirth <= 21) {
                    outputSignOfZodiac = "Taurus"; // Телец
                } else {
                    outputSignOfZodiac = "Gemini"; // Близнецы
                }
                break;
            case 6:
                if (entryDayOfBirth >= 1 & entryDayOfBirth <= 21) {
                    outputSignOfZodiac = "Gemini"; // Козерог
                } else {
                    outputSignOfZodiac = "Cancer"; // Рак
                }
                break;
            case 7:
                if (entryDayOfBirth >= 1 & entryDayOfBirth <= 22) {
                    outputSignOfZodiac = "Cancer"; // Рак
                } else {
                    outputSignOfZodiac = "Leo "; // Лев
                }
                break;
            case 8:
                if (entryDayOfBirth >= 1 & entryDayOfBirth <= 21) {
                    outputSignOfZodiac = "Leo "; // Лев
                } else {
                    outputSignOfZodiac = "Virgo"; // Дева
                }
                break;
            case 9:
                if (entryDayOfBirth >= 1 & entryDayOfBirth <= 23) {
                    outputSignOfZodiac = "Virgo"; // Virgo
                } else {
                    outputSignOfZodiac = "Libra "; // Весы
                }
                break;
            case 10:
                if (entryDayOfBirth >= 1 & entryDayOfBirth <= 23) {
                    outputSignOfZodiac = "Libra "; // Весы
                } else {
                    outputSignOfZodiac = "Scorpio "; // Скорпион
                }
                break;
            case 11:
                if (entryDayOfBirth >= 1 & entryDayOfBirth <= 22) {
                    outputSignOfZodiac = "Scorpio "; // Скорпион
                } else {
                    outputSignOfZodiac = "Sagittarius "; // Стрелец
                }
                break;
            case 12:
                if (entryDayOfBirth >= 1 & entryDayOfBirth <= 22) {
                    outputSignOfZodiac = "Sagittarius "; // Стрелец
                } else {
                    outputSignOfZodiac = "Capricorn"; // Козерог
                }
        }
        System.out.println("Your dates of birth by Zodiac is\n" +
                "Year - " + outputYear + "\n" +
                "Month - " + outputSignOfZodiac);
    }
}

