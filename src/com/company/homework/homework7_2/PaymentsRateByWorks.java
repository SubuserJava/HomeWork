package com.company.homework.homework7_2;

public class PaymentsRateByWorks extends Employee {

    private double rateTypeOfWork1;
    private double numberTypeOfWork1;

    private double rateTypeOfWork2;
    private double numberTypeOfWork2;

    public PaymentsRateByWorks(String fio, String paymentMethod, double rateTypeOfWork1, double numberTypeOfWork1, double rateTypeOfWork2, double numberTypeOfWork2) {
        super(fio);
        this.paymentMethod = paymentMethod;
        this.rateTypeOfWork1 = rateTypeOfWork1;
        this.numberTypeOfWork1 = numberTypeOfWork1;
        this.rateTypeOfWork2 = rateTypeOfWork2;
        this.numberTypeOfWork2 = numberTypeOfWork2;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PaymentsRateByWorks {");
        sb.append("name = ").append(super.toString());
        sb.append(", method of pay = '").append(paymentMethod).append('\'');
        sb.append(", rateTypeOfWork1 = ").append(rateTypeOfWork1);
        sb.append(", numberTypeOfWork1 = ").append(numberTypeOfWork1);
        sb.append(", rateTypeOfWork2 = ").append(rateTypeOfWork2);
        sb.append(", numberTypeOfWork2 = ").append(numberTypeOfWork2);
        sb.append('}');
        return sb.toString();
    }

    public double getRateTypeOfWork1() {
        return rateTypeOfWork1;
    }

    public double getNumberTypeOfWork1() {
        return numberTypeOfWork1;
    }

    public double getRateTypeOfWork2() {
        return rateTypeOfWork2;
    }

    public double getNumberTypeOfWork2() {
        return numberTypeOfWork2;
    }
}
