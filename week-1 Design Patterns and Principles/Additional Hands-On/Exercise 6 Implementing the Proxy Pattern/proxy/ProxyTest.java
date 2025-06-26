package com.pattern.proxy;

public class ProxyTest {
    public static void main(String[] args) {
        Image img = new ProxyImage("sample.png");

        img.display(); // First time: loads + displays
        img.display(); // Second time: only displays
    }
}
