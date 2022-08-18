package com.company.homework.ExamTask;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

public class DebitCard implements Serializable {

    @Serial
    private static final long serialVersionUID = -6864362221449785181L;

    private String typeOfCurrency;
    private String numberOfDebitCard;
    private String typeOfCard = "Debit card";
    private BigDecimal currentBalance;

    public DebitCard(String typeOfCurrency, String numberOfDebitCard, String typeOfCard, BigDecimal currentBalance) {
        this.typeOfCurrency = typeOfCurrency;
        this.numberOfDebitCard = numberOfDebitCard;
        this.typeOfCard = typeOfCard;
        this.currentBalance = currentBalance;
    }
}
