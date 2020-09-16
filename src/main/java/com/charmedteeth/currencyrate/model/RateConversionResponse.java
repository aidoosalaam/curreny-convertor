package com.charmedteeth.currencyrate.model;

import lombok.Data;

@Data
public class RateConversionResponse {
    private String sourceCurr;
    private String destCurr;
    private String rate;
    private String inverseRate;
    private String lastUpdated;
    private String amount;
    private String convertedAmount;
    private String source;

    public String getInverseRate() {
        return inverseRate;
    }

    public void setInverseRate(String inverseRate) {
        this.inverseRate = inverseRate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

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

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
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

    public RateConversionResponse() {
    }
}
