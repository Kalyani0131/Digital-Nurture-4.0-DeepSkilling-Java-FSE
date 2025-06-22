package com.pattern.decorator;

public class SimpleCoffee implements Coffee {
    public String getDescription() {
        return "Simple Coffee";
    }
    public double cost() {
        return 50;
    }
}
