package com.charmedteeth.currencyrate.model;

import lombok.Data;

@Data
public class RateConvertRequest {
    private String sourceCurr;
    private String destCurr;
    private double amount;

    public String getSourceCurr() {
        return sourceCurr;
    }

    public void setSourceCurr(String sourceCurr) {
        this.sourceCurr = sourceCurr;
    }

    public String getDestCurr() {
        return destCurr;
    }

    public void setDestCurr(String destCurr) {
        this.destCurr = destCurr;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public RateConvertRequest() {
    }
}
