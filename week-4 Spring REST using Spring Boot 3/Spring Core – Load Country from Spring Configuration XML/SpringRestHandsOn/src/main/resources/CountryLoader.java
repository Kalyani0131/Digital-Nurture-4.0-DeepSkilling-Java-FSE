package com.example.core;

import com.example.model.Country;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CountryLoader {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Country country = context.getBean("country", Country.class);
        System.out.println("Loaded country: " + country);
    }
}
