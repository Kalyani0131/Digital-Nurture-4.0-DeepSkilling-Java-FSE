package com.pattern.adapter;

public class OldGateway {
    public void makePayment(String amount) {
        System.out.println("Old gateway processed payment: Rs. " + amount);
    }
}
