package com.company.homework.homework5_1;

public class Task06 {

    public static void main(String[] args) {   // Два цикла прверки и исключения цифр, т.к. может быть, что после первого
                                               // исключения возникнет сочетание со значением 13 (31434 -> 313 -> 3).

        int countExcludeNumber = 0;            // Другой вариант решения с помощью регулярных выражений.
        for (int countNumbers = 0; countNumbers < 99_999; countNumbers++) {

            if (String.valueOf(countNumbers).matches("\\d*4+\\d*|\\d*13+\\d*")) {
                countExcludeNumber++;
            }
        }
        System.out.println("You have to exclude " + countExcludeNumber + " numbers.");

//        int countNumbersArmyTechnics = 0;
//        for (int countNumbers = 4; countNumbers < 99_995; countNumbers++) {
//            StringBuilder tempStringNumber = new StringBuilder(Integer.toString(countNumbers));  // считывание в строку текущего индекса-номера.
//            do {
//                if (tempStringNumber.indexOf("4") == 0) {                                        // Проверка на совпадение 4.
//                    countNumbersArmyTechnics++;                                                  // Подсчёт, значит это число выпадает из номеров.
//                    tempStringNumber = tempStringNumber.replace(tempStringNumber.indexOf("4"), tempStringNumber.indexOf("4") + 1, "");
//                } else if (tempStringNumber.indexOf("13") == 0) {                                // Проверка на совпадение 13.
//                    countNumbersArmyTechnics++;                                                  // Подсчёт, значит это число выпадает из номеров.
//                    tempStringNumber = tempStringNumber.replace(tempStringNumber.indexOf("13"), tempStringNumber.indexOf("13") + 1, "");
//                }
//            } while (tempStringNumber.indexOf("4") == 0 | tempStringNumber.indexOf("13") == 0);
//
//            tempStringNumber.delete(0, tempStringNumber.length());                               // Очистка строковой переменной.
//        }
//        System.out.println("You have to exclude " + countNumbersArmyTechnics + " numbers.");     // Ответ - 13579 номеров.
    }
}

