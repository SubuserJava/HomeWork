package com.company.homework.ExamTask;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class CashAssets implements Serializable {

    @Serial
    private static final long serialVersionUID = 4634387731921841502L;

    private String currencyCashAssets;
    private BigDecimal amountCashSaving;

    public CashAssets(String currencyCashAssets, BigDecimal amountCashSaving) {
        this.currencyCashAssets = currencyCashAssets;
        this.amountCashSaving = amountCashSaving;
    }

    public String getCurrencyCashAssets() {
        return currencyCashAssets;
    }

    public void setCurrencyCashAssets(String currencyCashAssets) {
        this.currencyCashAssets = currencyCashAssets;
    }

    public BigDecimal getAmountCashSaving() {
        return amountCashSaving;
    }

    public void setAmountCashSaving(BigDecimal amountCashSaving) {
        this.amountCashSaving = amountCashSaving;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CashAssets that = (CashAssets) o;
        return Objects.equals(currencyCashAssets, that.currencyCashAssets) && Objects.equals(amountCashSaving, that.amountCashSaving);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currencyCashAssets, amountCashSaving);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CashAssets{");
        sb.append("currencyCashAssets='").append(currencyCashAssets).append('\'');
        sb.append(", amountCashSaving=").append(amountCashSaving);
        sb.append('}');
        return sb.toString();
    }
}
