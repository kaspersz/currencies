package com.example.currencies;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class Currencies {
    Map<String, Double> map = new HashMap<>();

    public Currencies() {
        map.put("EUR", 1.95);
    }

    public Map<String, Double> getMap() {
        return map;
    }

    public void setMap(Map<String, Double> map) {
        this.map = map;
    }
}
