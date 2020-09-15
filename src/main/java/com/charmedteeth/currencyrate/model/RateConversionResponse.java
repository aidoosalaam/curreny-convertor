package com.charmedteeth.currencyrate.model;

import lombok.Data;

@Data
public class RateConversionResponse {
    private String sourceCurr;
    private String destCurr;
    private String rate;
    private String date;
    private String amount;
    private String convertedAmount;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
