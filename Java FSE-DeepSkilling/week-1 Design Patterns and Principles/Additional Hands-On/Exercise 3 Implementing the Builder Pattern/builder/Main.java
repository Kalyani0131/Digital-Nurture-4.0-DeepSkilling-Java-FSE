package com.pattern.builder;

public class Main {
    public static void main(String[] args) {
        Phone phone = new PhoneBuilder()
                        .setOs("Android")
                        .setRam(8)
                        .setProcessor("Snapdragon")
                        .build();
        System.out.println(phone);
    }
}
