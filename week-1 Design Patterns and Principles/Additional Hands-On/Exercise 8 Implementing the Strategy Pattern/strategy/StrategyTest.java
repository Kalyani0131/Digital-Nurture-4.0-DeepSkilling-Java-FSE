package com.pattern.strategy;

public class StrategyTest {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setStrategy(new CreditCardPayment());
        context.executePayment(1500);

        context.setStrategy(new PayPalPayment());
        context.executePayment(2000);
    }
}
