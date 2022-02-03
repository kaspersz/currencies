package com.example.currencies;

import com.example.currencies.controller.CurrencyController;
import com.example.currencies.exceptions.CurrencyRestExceptionHandler;
import com.example.currencies.service.CurrencyService;
import com.example.currencies.service.CurrencyServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.context.WebApplicationContext;


import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/*@WebMvcTest
@ContextConfiguration(classes= RestAssuredConfig.class)*/
public class RestAssuredMockMvcWebContextTest {

    @Test
    void should_return_bad_request_when_incorrect_parameter_is_given(@Autowired WebApplicationContext context) throws Exception {
       given().webAppContextSetup(context).when().get("/currency/PLN").then().statusCode(400);
    }

}
/*@Configuration(proxyBeanMethods = false)*/
class RestAssuredConfig {
    @Bean
    CurrencyRestExceptionHandler currencyRestExceptionHandler(){
        return new CurrencyRestExceptionHandler();
    }
    @Bean
    public CurrencyController getCurrencyController(){
        Currencies currencies = new Currencies();
        CurrencyService currencyService = new CurrencyServiceImp(currencies);

        return new CurrencyController(currencyService);
    }

}
