package com.example.currencies.controller;

import com.example.currencies.exceptions.CurrencyNotFoundException;

import com.example.currencies.model.CurrencyResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class CurrencyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void get_ok_status_when_parameter_is_in_map() throws Exception {
        mockMvc.perform(get("/currency/EUR")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void get_bad_request_when_parameter_is_not_correct() throws Exception {
        mockMvc.perform(get("/currency/PLN")).andDo(print()).andExpect(status().isBadRequest());
    }

    @ParameterizedTest
    @ValueSource(strings = {"xaz", "CHF", "ADASDcc"})
    public void should_return_client_bad_request_when_wrong_path_as_currency_code_given(String currency) throws Exception {
        mockMvc.perform(get("/currency/" + currency))
                .andDo(print())
                .andExpect(status()
                        .isBadRequest());
    }
}