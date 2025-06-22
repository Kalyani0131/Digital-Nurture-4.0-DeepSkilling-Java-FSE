package com.pattern.decorator;

public class MilkDecorator implements Coffee {
    private Coffee coffee;

    public MilkDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public String getDescription() {
        return coffee.getDescription() + ", with milk";
    }

    public double cost() {
        return coffee.cost() + 20;
    }
}
