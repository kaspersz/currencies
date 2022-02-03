package com.example.currencies.model;

public class CurrencyResponse {
    private Double value;

    public CurrencyResponse(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
