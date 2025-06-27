package com.pattern.adapter;

public class OldGatewayAdapter implements PaymentProcessor {
    private OldGateway gateway;

    public OldGatewayAdapter(OldGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void processPayment(double amount) {
        gateway.makePayment(String.valueOf(amount));
    }
}
