package com.company.homework.homework7_1.Task05;

public class Main {

    public static void main(String[] args) {

        ComplexNumber complexNum1 = new ComplexNumber(1.0d, 2.0d);
        ComplexNumber complexNum2 = new ComplexNumber(1, -2);
        ComplexNumber complexNum3 = new ComplexNumber(0.0d, 2.0d);
        ComplexNumber complexNum4 = new ComplexNumber(5.2d, 6.9d);
        ComplexNumber complexNum5 = new ComplexNumber(5.2d, 6.9d);

        System.out.println(complexNum1);  // Работает переопределённый метод toString
        System.out.println(complexNum2);
        System.out.println(complexNum3);
        System.out.println(complexNum4);
        System.out.println();

        System.out.println(CalcComplex.addComplex(complexNum1, complexNum4)); // 6.2 + 8.9i
        System.out.println(CalcComplex.subComplex(complexNum4, complexNum2)); // 4.2 + 8.9i
        System.out.println(CalcComplex.muxComplex(complexNum1, complexNum4)); // -8.600000000000001 + 17.3i   ... Проблема расчётов числа типа double.
        System.out.println(CalcComplex.divComplex(complexNum4, complexNum1)); // 7.870057685088806 - 1.4497474683058327i
        System.out.println(CalcComplex.compareComplex(complexNum4, complexNum5)); // true
        System.out.println(CalcComplex.compareComplex(complexNum2, complexNum4)); // false
        System.out.println();

        CalcComplex.addSelfComplex(complexNum1);  // Комплексное число прибавить самого себя.
        System.out.println(complexNum1);          // 2.0 + 4.0i
        CalcComplex.subSelfComplex(complexNum2);  // Комплексное число вычесть из самого себя.
        System.out.println(complexNum2);          // 0.0
        CalcComplex.muxSelfComplex(complexNum4);  // Умножение на самого себя.
        System.out.println(complexNum4);          // -0.3464342571144634 - 4.7807927481795955i
        CalcComplex.divSelfComplex(complexNum5);  // Деление на самого себя.
        System.out.println(complexNum5);          // 1.0 + 1.0i
    }
}
