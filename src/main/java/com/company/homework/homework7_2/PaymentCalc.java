package com.company.homework.homework7_2;

public class PaymentCalc {

    public static double calcEmployeeRateByDay(double rateByDay, double countOfDays) {      // Подсчёт по ставке
        return (Math.round(rateByDay * countOfDays * 100d)) / 100d;
    }

    public static double calcEmployeeRateByHour(double rateByHours, double numberOfHour) {   // Подсчёт по часам.
        return (Math.round(rateByHours * numberOfHour * 100d)) / 100d;
    }

    public static double calcEmployeeRateByWork(double rateTypeOfWork1, double numberTypeOfWork1, double rateTypeOfWork2, double numberTypeOfWork2) { // Подсчёт по сдельной работе
        return (Math.round((rateTypeOfWork1 * numberTypeOfWork1 + rateTypeOfWork2 * numberTypeOfWork2) * 100d)) / 100d;
    }
}
