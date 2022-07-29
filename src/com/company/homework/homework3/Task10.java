package com.company.homework.homework3;

public class Task10 {

    static final int FLOOR_NUMBERS = 9; //Число этажей в доме
    static final int TOTAL_COUNT_OF_APARTMENT = 144; // Всего квартир в доме.

    public static void main(String[] args) {

        int numberApartment = 46; // Данный номер квартиры (N). Сменяемый параметр
        int FlatsOnFloorCounts = 4; // Число квартир на этаже (M). Сменяемый параметр

        int countOfEntrance = TOTAL_COUNT_OF_APARTMENT / FLOOR_NUMBERS / FlatsOnFloorCounts; // Число подъездов в доме
        int countFloorsInEntrance = TOTAL_COUNT_OF_APARTMENT / countOfEntrance; // Число квартир в подъезде

        int entranceIndex = 1;
        do {
            boolean arg1 = numberApartment >= (entranceIndex * countFloorsInEntrance - countFloorsInEntrance); // Выявление, больше ли номер квартиры чем первая квартира в подъезде
            boolean arg2 = numberApartment <= entranceIndex * countFloorsInEntrance;  // Выявление меньше ли номер последней квартиры в подъезде.
            if (arg1 & arg2) {                                                        // Если совпадение по двум параметрам, то вывод результата
                System.out.println("Number of entrance is: " + entranceIndex);       // Выход из цикла в случае совпадения.
                break;
            }
            entranceIndex++;                        // Переход к следующему подъезду.
        } while (entranceIndex <= countOfEntrance); // Количество циклов в зависимости от количества подъездов в доме.
    }
}