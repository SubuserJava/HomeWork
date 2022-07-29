package com.company.homework.homework7_1.Task04;

public class MainString {

    protected char[] charArray;
    protected int lengthOfString;

    public MainString() {                                  // Без параметров
    }

    public MainString(char[] charArray, int lengthOfString) {
        this.charArray = charArray;
        this.lengthOfString = lengthOfString;
    }

    public MainString(String stringLiteral) {               // Конструктор экземпляра класса с передачей строки.
        char[] charArray = stringLiteral.toCharArray();
        this.charArray = charArray;
        this.lengthOfString = charArray.length;
    }

    public MainString(char stringCharacter) {               // Конструктор с передачей символа.
        char[] charArray = {stringCharacter};
        this.charArray = charArray;
        this.lengthOfString = charArray.length;
    }

    public int getLengthOfString() {
        return lengthOfString;
    }  // Метод получения длины строки.

    public void makeStringEmpty(char[] charArray) {         // Метод очистки строки.
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = '\u0000'; //Character.MIN_VALUE;
        }
    }

    public void findCharacter(char charFind) {              // Метод поиска символа.
        boolean isTempVar = false;
        for (char c : charArray) {
            if (c == charFind) {
                isTempVar = true;
                break;
            }
        }
        if (isTempVar) {
            System.out.println("Character found.");
        } else {
            System.out.println("Character not found.");
        }
    }
}
