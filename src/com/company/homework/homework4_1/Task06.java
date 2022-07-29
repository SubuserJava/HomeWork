package com.company.homework.homework4_1;

public class Task06 {

    public static void main(String[] args) {    // Восьмизначные числа в которых не повторяются цифры.

        final long DIVIDER = 12345;       // Постоянный делитель 12345 по условию задачи.
        int unicNumCount = 0;             // Подсчёт уникальных чисел.

        for (int eightDigitNum = 10000000; eightDigitNum <= 99999999; eightDigitNum++) { // Цикл для вывода чисел из диапазона.

            if (eightDigitNum % DIVIDER == 0) {    // Отбрасывание чисел не далящихся на 12345.
                String eightDigitNumString = String.valueOf(eightDigitNum);  // Разделение полученного из цикла числа на символы в строке.
                char[] charsArray = eightDigitNumString.toCharArray();   // Перевод символов в массив символов для анализа числа.

                boolean checkUnicumNum = false;                  // Возвращаемая переменная из цикла проверки числа.
                for (int tempIndex = 0; tempIndex < charsArray.length; tempIndex++) {   // Цикл для проверки чисел на тождество.
                    if (eightDigitNumString.indexOf(charsArray[tempIndex]) != tempIndex) {  // Проверка чисел внутри массива через метод .indexOf()
                        checkUnicumNum = false;  // Если совпадений по индексам нет, то checkUnicNum остаётся false. Проверка прерывается.
                        break;
                    } else {
                        checkUnicumNum = true;   // Совпадения есть checkUnicNum -> true.
                    }
                }
                if (checkUnicumNum) {               // Проверка возвращаемой переменной, инкрементирование счётчика при обнаружении уникального числа.
                    unicNumCount++;              // Значение переменной false, ничего не происходит. Проверка продолжается.
                }
            }
        }
        System.out.println("Total value of unique numbers is " + unicNumCount);  // 137
    }
}

