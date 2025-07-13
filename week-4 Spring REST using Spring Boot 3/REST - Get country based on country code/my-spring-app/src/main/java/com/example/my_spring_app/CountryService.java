package com.example.my_spring_app;

import  com.example.my_spring_app.Country;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CountryService {

    private Map<String, Country> countryMap = new HashMap<>();

    public CountryService() {
        countryMap.put("IN", new Country("IN", "India"));
        countryMap.put("US", new Country("US", "United States"));
        countryMap.put("DE", new Country("DE", "Germany"));
        countryMap.put("JP", new Country("JP", "Japan"));
    }

    public Country getCountryByCode(String code) {
        return countryMap.get(code.toUpperCase());
    }

    public Collection<Country> getAllCountries() {
        return countryMap.values();
    }
}
