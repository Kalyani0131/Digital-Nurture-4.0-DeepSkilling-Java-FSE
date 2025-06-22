package com.pattern.proxy;

public class Main {
    public static void main(String[] args) {
        Internet internet = new ProxyInternet();
        internet.connectTo("example.com");
        internet.connectTo("banned.com");
    }
}
