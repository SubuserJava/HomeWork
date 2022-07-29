package com.company.homework.homework7_2;

public class PaymentsRateByHours extends Employee{

    private double rateByHour;
    private double numberOfHour;

    public PaymentsRateByHours(String fio, String paymentMethod, double rateByHour, double numberOfHour) {
        super(fio);
        this.paymentMethod = paymentMethod;
        this.rateByHour = rateByHour;
        this.numberOfHour = numberOfHour;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PaymentsRateByHours {");
        sb.append("name = ").append(super.toString());
        sb.append(", method of pay ='").append(paymentMethod).append('\'');
        sb.append(", rateByHour =").append(rateByHour);
        sb.append(", numberOfHour =").append(numberOfHour);
        sb.append('}');
        return sb.toString();
    }

    public double getRateByHour() {
        return rateByHour;
    }

    public double getNumberOfHour() {
        return numberOfHour;
    }
}
