// задача соответствия животного с издаваемым им звуками. Задача 3.3

package com.company.homework.homework3;

import java.util.Scanner;

public class Task03 {

    public static void main(String[] args) {

        Scanner consoleSystemIn = new Scanner(System.in); // Ввод цифры по имени животного.
        System.out.print("""
                Enter number of proposed animals:
                1 - Dog;
                2 - Cat;
                3 - Crow;
                4 - Horse;
                5 - Hedgehog;
                6 - Sheep;
                7 - Cow;
                8 - Frog;
                9 - Rooster;
                10 - Pig.
                Number -\s""");
        byte inputNumber = consoleSystemIn.nextByte();

        switch (inputNumber) { // Вывод звука животного в зависимости от введённой цифры.
            case 1 -> System.out.println("Sound the animal dog is 'Gau-gau!'");
            case 2 -> System.out.println("Sound the animal cat is 'Mau-mau!'");
            case 3 -> System.out.println("Sound the animal crow is 'Karrr-karr!'");
            case 4 -> System.out.println("Sound the animal horse is 'Yii-gogo!'");
            case 5 -> System.out.println("Sound the animal hedgehog is 'Frr-frr!'");
            case 6 -> System.out.println("Sound the animal sheep is 'Mmee-mmee!'");
            case 7 -> System.out.println("Sound the animal cow is 'Muuuuu!'");
            case 8 -> System.out.println("Sound the animal frog is 'Kvaa-kvaa!'");
            case 9 -> System.out.println("Sound the animal rooster is 'Kukarekuuu!'");
            case 10 -> System.out.println("Sound the animal pig is 'Hrju-hrju!'");
        }
    }
}
