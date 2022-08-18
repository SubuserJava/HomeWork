package com.company.homework.ExamTask;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

public class CreditCard implements Serializable {

    @Serial
    private static final long serialVersionUID = 3342271236302648491L;

    private String typeOfCurrency;
    private String numberOfCreditCard;
    private String typeOfCard = "Credit card";
    private BigDecimal limitOfOverdraft;
    private BigDecimal currentBalance;
    private Integer loanInterestRate;
    private BigDecimal monthlyPaymentByCredit;

    public CreditCard(String typeOfCurrency, String numberOfCreditCard, String typeOfCard, BigDecimal limitOfOverdraft,
                      BigDecimal currentBalance, Integer loanInterestRate, BigDecimal monthlyPaymentByCredit) {
        this.typeOfCurrency = typeOfCurrency;
        this.numberOfCreditCard = numberOfCreditCard;
        this.typeOfCard = typeOfCard;
        this.limitOfOverdraft = limitOfOverdraft;
        this.currentBalance = currentBalance;
        this.loanInterestRate = loanInterestRate;
        this.monthlyPaymentByCredit = monthlyPaymentByCredit;
    }
}
