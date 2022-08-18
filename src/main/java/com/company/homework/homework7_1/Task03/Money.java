package com.company.homework.homework7_1.Task03;

public class Money {

    protected long grivna;
    protected byte kopecks;

    public Money(long grivna, byte kopecks) {
        this.grivna = grivna;
        this.kopecks = kopecks;
    }

    public Money() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Amount your money: ");
        sb.append(grivna);
        sb.append(",").append(kopecks);
        sb.append(" grivna.");
        return sb.toString();
    }

    public void setGrivna(long grivna) {
        if (grivna < 0) {
            System.out.println("Your amount of grivna can't be negative. Your amount of grivna has not be change.");
        } else {
            this.grivna = grivna;
        }
    }

    public void setKopecks(byte kopecks) {
        if (kopecks < 0) {
            System.out.println("Your amount of kopecks can't be negative. Your amount of kopecks has not be change.");
        } else {
            this.kopecks = kopecks;
        }
    }
}

