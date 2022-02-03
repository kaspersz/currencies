package com.example.currencies.controller;

import com.example.currencies.exceptions.CurrencyNotFoundException;
import com.example.currencies.model.CurrencyResponse;
import com.example.currencies.service.CurrencyService;
import com.example.currencies.service.CurrencyServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/currency")
public class CurrencyController {

    private CurrencyService currencyService;

    @Autowired
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/{code}")
    @ResponseBody
    public CurrencyResponse getCurrency(@PathVariable String code) {
        return currencyService.getCurrencyAmount(code);

    }
}
