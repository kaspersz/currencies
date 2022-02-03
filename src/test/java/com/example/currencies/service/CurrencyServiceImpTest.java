package com.example.currencies.service;

import com.example.currencies.Currencies;
import com.example.currencies.exceptions.CurrencyNotFoundException;
import com.example.currencies.model.CurrencyResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyServiceImpTest {


    final CurrencyService currencyServiceImp = new CurrencyServiceImp(new Currencies());

    @Test
    public void should_return_correct_currency_value(){
        CurrencyResponse currencyResponse = currencyServiceImp.getCurrencyAmount("EUR");

        assertEquals(1.95, currencyResponse.getValue());
    }
    @Test
    public void should_return_exception_while_bad_poarameter_is_given(){
        assertThrows(CurrencyNotFoundException.class, ()->currencyServiceImp.getCurrencyAmount("PLN"));
    }

}