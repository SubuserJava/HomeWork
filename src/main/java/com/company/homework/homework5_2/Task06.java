package com.company.homework.homework5_2;

import java.util.Arrays;

public class Task06 {

    public static void main(String[] args) {

        int[] randomNumArray = new int[10];
        System.out.println("Your array: ");
        for (int elementArr = 0; elementArr < randomNumArray.length; elementArr++) {
            randomNumArray[elementArr] = (int) (Math.random() * 21) - 10;   // Случайные числа от -10 до 10.
            System.out.print("[" + randomNumArray[elementArr] + "]");
        }
        System.out.println();              // Мне кажется, получилось сложновато. Можно было попробовать с помощью стэка (масиива). Не хватило времени на обдумывание...

        Arrays.sort(randomNumArray);
        System.out.println();

        int countMismatch = 0;             // Счётчик уникальных чисел.
        outer:
        for (int countPosition = 0; countPosition != randomNumArray.length - 1; countPosition++) {                                     // Цикл проверки каждого элемента.
            if (randomNumArray[countPosition] == randomNumArray[countPosition + 1]) {          // Сравнение элемента со следующим.
                if (countPosition == randomNumArray.length - 1) {                              // Если позиция (countPosition) последний элемент - выход. Иначе, подсчёт совпадений.
                    break outer;
                }
                while (randomNumArray[countPosition] == randomNumArray[countPosition + 1]) {   // При совпадении, проверка следующих элементов с увеличением счётчика из цикла перебора элементов.
                    countPosition++;
                    if (countPosition == randomNumArray.length - 1) {                          // Опять же проверка на позицию последнего элемента. Результат - выход из цикла.
                        break outer;
                    }
                }
            } else {
                System.out.println("Unique element value of array is " + randomNumArray[countPosition] + ". Its index is " + countPosition); // Вывод на печать уникальных элементов.
                countMismatch++;
            }
        }

        if (randomNumArray[randomNumArray.length - 1] != randomNumArray[randomNumArray.length - 2]) {           // Проверка последнего элемента с предпоследним.
            System.out.println("Unique element value of array is " + randomNumArray[randomNumArray.length - 1] + ". Its index is " + (randomNumArray.length - 1));
            System.out.println("Total number of unique elements is " + ++countMismatch);
        } else {
            System.out.println("Total number of unique elements is " + countMismatch);
        }
    }
}
