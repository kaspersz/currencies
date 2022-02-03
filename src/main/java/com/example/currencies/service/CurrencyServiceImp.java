package com.example.currencies.service;

import com.example.currencies.Currencies;
import com.example.currencies.exceptions.CurrencyNotFoundException;
import com.example.currencies.model.CurrencyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImp implements CurrencyService{

    private Currencies currencies;

    public CurrencyServiceImp() {
    }

    @Autowired
    public CurrencyServiceImp(Currencies currencies) {
        this.currencies = currencies;
    }

    @Override
    public CurrencyResponse getCurrencyAmount(String code) {
        if(!this.currencies.getMap().containsKey(code)){
            throw new CurrencyNotFoundException(code);
        }
        Double result = this.currencies.getMap().get(code);
        return new CurrencyResponse(result);
    }
}
