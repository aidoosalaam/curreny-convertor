package com.charmedteeth.currencyrate.model;

import lombok.Data;

@Data
public class RateConversionResponse {
    private String baseCurr;
    private String qouteCurr;
    private double rate;
    private String inverseRate;
    private String lastUpdated;
    private String amount;
    private String convertedAmount;
    private String source;

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

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getInverseRate() {
        return inverseRate;
    }

    public void setInverseRate(String inverseRate) {
        this.inverseRate = inverseRate;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(String convertedAmount) {
        this.convertedAmount = convertedAmount;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public RateConversionResponse() {
    }
}
