package com.company.homework.homework7_1.Task05;

public class CalcComplex extends ComplexNumber {

    public CalcComplex(Double re, Double im) {
        super(re, im);
    }

    public CalcComplex(Integer re, Integer im) {
        super(re, im);
    }

    public static ComplexNumber addComplex(ComplexNumber complexNum1, ComplexNumber complexNum2) {  // Сложение
        Double realPart = complexNum1.getRe() + complexNum2.getRe();
        Double imaginePart = complexNum1.getIm() + complexNum2.getIm();
        return new ComplexNumber(realPart, imaginePart);
    }

    public static ComplexNumber subComplex(ComplexNumber complexNum1, ComplexNumber complexNum2) {  // Вычитание
        Double realPart = complexNum1.getRe() - complexNum2.getRe();
        Double imaginePart = complexNum1.getIm() - complexNum2.getIm();
        return new ComplexNumber(realPart, imaginePart);
    }

    public static ComplexNumber muxComplex(ComplexNumber complexNum1, ComplexNumber complexNum2) {  // Умножение
        Double realPart = complexNum1.getRe() * complexNum2.getRe() - complexNum1.getIm() * complexNum2.getIm();
        Double imaginePart = complexNum1.getRe() * complexNum2.getIm() + complexNum1.getIm() * complexNum2.getRe();
        return new ComplexNumber(realPart, imaginePart);
    }

    public static ComplexNumber divComplex(ComplexNumber complexNum1, ComplexNumber complexNum2) {
        if (complexNum1.getRe() == 0 | complexNum2.getIm() == 0) {
            System.out.println("Division by zero is not possible. Number will remain unchanged.");
            return null;
        } else {
            Double realPart = (complexNum1.getRe() * complexNum2.getRe() + complexNum1.getIm() * complexNum2.getIm()) / (Math.sqrt(complexNum2.getRe()) + Math.sqrt(complexNum2.getIm()));
            Double imaginePart = (complexNum1.getIm() * complexNum2.getRe() - complexNum1.getRe() * complexNum2.getIm()) / (Math.sqrt(complexNum2.getRe()) + Math.sqrt(complexNum2.getIm()));
            return new ComplexNumber(realPart, imaginePart);
        }
    }

    public static boolean compareComplex(ComplexNumber complexNum1, ComplexNumber complexNum2) {  // Сравнение
        return Double.doubleToLongBits(complexNum1.getRe()) == Double.doubleToLongBits(complexNum2.getRe()) &&
                Double.doubleToLongBits(complexNum1.getIm()) == Double.doubleToLongBits(complexNum2.getIm());
    }

    // Методы +=, -=, *=, /=
    public static void addSelfComplex(ComplexNumber complexNum) {
        complexNum.setRe(complexNum.getRe() * 2);
        complexNum.setIm(complexNum.getIm() * 2);
    }

    public static void subSelfComplex(ComplexNumber complexNum) {
        complexNum.setRe(0.0d);
        complexNum.setIm(0.0d);
    }

    public static void muxSelfComplex(ComplexNumber complexNum) {
        complexNum.setRe(Math.sqrt(complexNum.getRe()) - Math.sqrt(complexNum.getIm()));
        complexNum.setIm(complexNum.getRe() * complexNum.getIm() + complexNum.getIm() * complexNum.getRe());
    }

    public static void divSelfComplex(ComplexNumber complexNum) {
        if (complexNum.getRe() == 0 | complexNum.getIm() == 0) {
            System.out.println("Division by zero is not possible. Number will remain unchanged.");
        } else {
            complexNum.setRe(1.0d);
            complexNum.setIm(1.0d);
        }

    }
}
