package com.example.currencies.exceptions;

public class CurrencyNotFoundException extends RuntimeException{
    String id;

    public CurrencyNotFoundException(String id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return "The currency " + this.id + " has not been found we can show you only EUR, USD and PLN";
    }
}
