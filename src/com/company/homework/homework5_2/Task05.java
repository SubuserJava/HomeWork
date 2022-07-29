package com.company.homework.homework5_2;

import java.util.Arrays;

public class Task05 {

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
        int countMatch = 1;        // Счётчик совпадений.
        int countPosition = 0;     // Счётчик позиции в массиве.
        outer: do {                                                                     // Цикл проверки каждого элемента.
            if (randomNumArray[countPosition] == randomNumArray[countPosition + 1]) {    // Сравнение элемента со следующим.
                while (randomNumArray[countPosition] == randomNumArray[countPosition + 1]) {   // При совпадении, подсчёт в цикле с условием выхода из цикла по неравенству соследующим элементом.
                    countMatch++;                                                        // Цикл подсчитывает повторы как в середине, так и в конце. Условие выхода по предпоследнему элементу ниже.
                    countPosition++;
                    if (countPosition == randomNumArray.length - 1) {                          // Прерывание цикла подсчёта по достижении предпоследнего элемента.
                        System.out.println("Array element " + randomNumArray[countPosition] + " repeats " + countMatch + " times." );  // Печать элемента и кол-ва совпадений до последнего элемента.
                        break outer;
                    }
                }
                System.out.println("Array element " + randomNumArray[countPosition] + " repeats " + countMatch + " times." );  // Печать элемента и кол-ва совпадений.
                countMatch = 1;                                                                // Сброс счётчика совпадений. Для подсчёта следующих совпадекний.
            } else {
                System.out.println("Array element " + randomNumArray[countPosition] + " repeats 1 times.");  // При несовпадении со следующим элементом, печать элемента и кол-ва повторов 1 раз.
            }
            countPosition++;                                                                   // Увеличение счётчика элементов массива.
        } while (countPosition != randomNumArray.length - 1);                                  // Условие выхода из общего цикла по достижении предпоследней позиции.

        if (randomNumArray[randomNumArray.length - 1] != randomNumArray[randomNumArray.length - 2]) {                   // Проверка последнего элемента с предыдущим.
            System.out.println("Array element " + randomNumArray[randomNumArray.length - 1] + " repeats 1 time.");      // Печать результата, если последний элемент не равен предыдущему
        }          // Иначе - конец.
    }
}





