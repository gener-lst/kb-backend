package com.kb.itisme.exchangeRate.controller;

import com.kb.itisme.exchangeRate.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ExchangeRateController {

    @Autowired
    private ExchangeRateService exchangeRateService;

    @GetMapping("/api/exchange-rate")
    public Map<String, Object> getExchangeRate(@RequestParam String currency) {
        BigDecimal exchangeRate = exchangeRateService.getExchangeRate(currency);
        Map<String, Object> response = new HashMap<>();
        response.put("currency", currency);
        response.put("exchangeRate", exchangeRate);
        return response;
    }
}
