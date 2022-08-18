package com.company.homework.ExamTask;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

public class Wallet implements Serializable {

    @Serial
    private static final long serialVersionUID = 3238031113754663359L;

    private String nameOfWallet;
    private String typeCurrencyOfWallet;
    private BigDecimal totalAmount;

}
