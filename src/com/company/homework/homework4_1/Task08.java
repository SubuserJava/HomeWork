package com.company.homework.homework4_1;

public class Task08 {

    public static void main(String[] args) {

        int[] intArrayClock = new int[4];                              // Объявление массива на 4 цифры. Заполнение массива 0-ми по умолчанию.
        int countCheck = 0;                                             // Объявление переменной счётчика совпадений симметричных значений времени.
        for (int num1 = 0; num1 < 3; num1++) {                          // Цикл для значения часов (десятки, от 0 до 2-х).
            intArrayClock[0] = num1;                                   // Присваивание значения десятков часов (от 0 до 2-х десятков) 1-му эл-ту массива.
            for (int num2 = 0; num2 < 10; num2++) {                     // Цикл единиц значений часов (от 0 до 9).
                intArrayClock[1] = num2;                               // Присваивание значения единиц часов 2-му эл-ту массива.
                for (int num3 = 0; num3 < 6; num3++) {                 // Цикл по минутам (десятки минут, от 0 до 5).
                    intArrayClock[2] = num3;                           // Присваивание знач. десятков часов 3-му эл-ту массива.
                    for (int num4 = 0; num4 < 10; num4++) {             // Цикл по минутам (единицы, от 0 до 9)
                        intArrayClock[3] = num4;                       // Присваивание знач. единиц минут 4-му эл-ту массива

                        boolean varCheck = false;            // Проверочная переменная совпадений по симметрии.
                        int index1, index2;                  // Объявеление 2-х переменных для управления циклом.
                        for (index1 = 0, index2 = 3; index1 < index2; index1++, index2--) {     // Цикл для проверки на симметричность значений в массиве
                            if (intArrayClock[index1] == intArrayClock[index2]) {             // с 1-ого и последнего эл-та массива навстречу.
                                varCheck = true;
                            } else {
                                varCheck = false;        // При отсутствии совпадений, проверочная переменная остаётся false. Выход из цикла проверки.
                                break;
                            }
                        }
                        if (intArrayClock[0] == 2 & intArrayClock[1] > 3) {   // Добавление условия если на часах больше, чем 23, то проверочная переменная всегда false.
                            varCheck = false;                                 // Счётчик не пополняется и часы не выводятся.
                        }
                        if (varCheck) {
                            countCheck++;                     // Подсчёт совпадений. Вывод совпадений в формате электронных часов hh:mm.
                            System.out.println(intArrayClock[0] + "" + intArrayClock[1] + ":" + intArrayClock[2] + "" + intArrayClock[3]);
                        }                                     // 00:00 01:10 02:20 ... 21:12 22:22 23:32
                    }
                }
            }
        }

        System.out.println("\nTotal numbers of symmetrical combinations of clock values is " + countCheck); // Общее число совпадений 16
    }
}

