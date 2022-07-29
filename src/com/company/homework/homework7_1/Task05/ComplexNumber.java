package com.company.homework.homework7_1.Task05;

public class ComplexNumber {

    private Double re;
    private Double im;

    public ComplexNumber(Double re, Double im) {  // Конструкторы
        this.re = re;
        this.im = im;
    }

    public ComplexNumber(Integer re, Integer im) {
        this.re = (double) re;
        this.im = (double) im;
    }

    public Double getRe() {
        return re;
    }

    public void setRe(Double re) {
        this.re = re;
    }

    public Double getIm() {
        return im;
    }

    public void setIm(Double im) {
        this.im = im;
    }

    @Override
    public String toString() {
        if (im == 0) {
            return re + "";
        } else if (re == 0) {
            return im + "i";
        } else if (im < 0) {
            return re + " - " + (-im) + "i";
        }
        return re + " + " + im + "i";
    }
}
