package com.charmedteeth.currencyrate.model;

import lombok.Data;

@Data
public class RateConvertRequest {
    private String baseCurr;
    private String qouteCurr;
    private double amount;

    public String getBaseCurr() {
        return baseCurr;
    }

    public void setBaseCurr(String baseCurr) {
        this.baseCurr = baseCurr;
    }

    public String getQouteCurr() {
        return qouteCurr;
    }

    public void setQouteCurr(String qouteCurr) {
        this.qouteCurr = qouteCurr;
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
