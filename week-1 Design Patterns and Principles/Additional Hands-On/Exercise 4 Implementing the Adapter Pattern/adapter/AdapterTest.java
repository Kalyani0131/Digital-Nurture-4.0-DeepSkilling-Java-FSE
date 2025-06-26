package com.pattern.adapter;

public class AdapterTest {
    public static void main(String[] args) {
        PaymentProcessor processor = new OldGatewayAdapter(new OldGateway());
        processor.processPayment(1500.75);
    }
}
