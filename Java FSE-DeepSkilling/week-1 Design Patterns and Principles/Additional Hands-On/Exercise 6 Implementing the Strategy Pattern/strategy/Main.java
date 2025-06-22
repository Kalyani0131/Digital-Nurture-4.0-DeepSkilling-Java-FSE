package com.pattern.strategy;

public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext(new CreditCardPayment());
        context.executePayment(500);

        context = new PaymentContext(new UPIPayment());
        context.executePayment(300);
    }
}
