package com.company.homework.homework6_1;

public class Main {

    public static void main(String[] args) {

//        int numberOfWords = 10;
//        String[] randomStrings = new String[numberOfWords];
//        Random random = new Random();
//        for (int i = 0; i < numberOfWords; i++) {
//            char[] word = new char[random.nextInt(8) + 3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
//            for (int j = 0; j < word.length; j++) {
//                word[j] = (char) ('a' + random.nextInt(26));
//            }
//            randomStrings[i] = new String(word);
//        }
//        System.out.println(Arrays.toString(randomStrings));

//        System.out.println(Arrays.toString(getRandomStringArray(10)));
//
//    }
//
//    private static String[] getRandomStringArray(int numberStringInArr) {
//        String latinLettersString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
//        String[] stringArray = new String[numberStringInArr];
//        for (int countElementsArray = 0; countElementsArray < numberStringInArr; countElementsArray++) {
//            StringBuilder randomString = new StringBuilder();
//            for (int countCharWord = 0; countCharWord < (int) (Math.random() * 9); countCharWord++) {   // Цикл количеством шагов размером слова
//                randomString.append(latinLettersString.charAt((int) (Math.random() * 50)));
//            }
//            stringArray[countElementsArray] = randomString.toString();
//
//        }
//        return stringArray;
//    }

        int a = 10;
        int b = 20;
        int c = 0;
        System.out.println(getValue(a, b, c));

    }

    private static int getValue(int a, int b,int c) {

        c = a + b;

        return c;
    }
}
