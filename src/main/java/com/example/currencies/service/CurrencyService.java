package com.example.currencies.service;

import com.example.currencies.model.CurrencyResponse;

public interface CurrencyService {
    CurrencyResponse getCurrencyAmount(String code);
}
