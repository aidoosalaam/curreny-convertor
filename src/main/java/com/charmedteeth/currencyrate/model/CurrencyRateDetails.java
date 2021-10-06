package com.charmedteeth.currencyrate.model;

import lombok.Data;

@Data
public class CurrencyRateDetails {
    private String code;
    private String alphaCode;
    private String numericCode;
    private String name;
    private double rate;
    private String date;
    private String inverseRate;

    public CurrencyRateDetails() {
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAlphaCode() {
        return alphaCode;
    }

    public void setAlphaCode(String alphaCode) {
        this.alphaCode = alphaCode;
    }

    public String getNumericCode() {
        return numericCode;
    }

    public void setNumericCode(String numericCode) {
        this.numericCode = numericCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInverseRate() {
        return inverseRate;
    }

    public void setInverseRate(String inverseRate) {
        this.inverseRate = inverseRate;
    }

    /*
    *
    *  "code":"AUD",
      "alphaCode":"AUD",
      "numericCode":"036",
      "name":"Australian Dollar",
      "rate":0.23431492649921,
      "date":"Tue, 15 Sep 2020 00:00:01 GMT",
      "inverseRate":4.267760551752
      *
    * */
}
