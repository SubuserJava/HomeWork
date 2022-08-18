package com.company.homework.homework7_2;

public class PaymentsRateByDay extends Employee {

    private double rateByDay;
    private double countOfDays;

    public PaymentsRateByDay(String fio, String paymentMethod, double rateByDay, double countOfDays) {
        super(fio);
        this.paymentMethod = paymentMethod;
        this.rateByDay = rateByDay;
        this.countOfDays = countOfDays;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PaymentsRateByDay {");
        sb.append("name = ").append(super.toString());
        sb.append(", method of pay = '").append(paymentMethod).append('\'');
        sb.append(", rateByDay = ").append(rateByDay);
        sb.append(", countOfDays = ").append(countOfDays);
        sb.append('}');
        return sb.toString();
    }

    public double getRateByDay() {
        return rateByDay;
    }

    public double getCountOfDays() {
        return countOfDays;
    }
}
