package com.pattern.builder;

public class BuilderTest {
    public static void main(String[] args) {
        Computer comp1 = new Computer.Builder()
                            .setCpu("Intel i7")
                            .setRam(16)
                            .setStorage(512)
                            .build();
        comp1.showConfig();

        Computer comp2 = new Computer.Builder()
                            .setCpu("AMD Ryzen 9")
                            .setRam(32)
                            .setStorage(1024)
                            .build();
        comp2.showConfig();
    }
}
