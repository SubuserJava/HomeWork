package com.company.homework.homework7_2;

public abstract class Employee {

    private String fio;
    public String paymentMethod;

    public Employee(String fio) {
        this.fio = fio;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(fio);
        sb.append(paymentMethod);
        return sb.toString();
    }

    public String getFio() {
        return fio;
    }
}
