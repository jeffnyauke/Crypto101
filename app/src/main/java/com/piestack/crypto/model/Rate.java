package com.piestack.crypto.model;

/**
 * Created by Jeffrey Nyauke on 11/2/2017.
 * Piestack.
 */

public class Rate {
    private String symbol;
    private String name;
    private String rate;

    public Rate(String symbol, String name, String rate){
        this.symbol = symbol;
        this.name = name;
        this.rate = rate;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
