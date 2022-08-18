package com.company.homework.ExamTask;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

public class BankingAssets implements Serializable {

    @Serial
    private static final long serialVersionUID = -3825394418375856990L;

    private String nameOfBank;
    private String bankAccountNumber;
    private String currencyAccount;
    private BigDecimal amountOnAccount;

    public BankingAssets(String nameOfBank, String bankAccountNumber, String currencyAccount, BigDecimal amountOnAccount) {
        this.nameOfBank = nameOfBank;
        this.bankAccountNumber = bankAccountNumber;
        this.currencyAccount = currencyAccount;
        this.amountOnAccount = amountOnAccount;
    }
}
