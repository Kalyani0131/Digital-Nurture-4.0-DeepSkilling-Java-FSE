package com.singleton;

public class Singleton {

    // Step 1: private static instance
    private static Singleton instance;

    // Step 2: private constructor
    private Singleton() {
        System.out.println("Singleton instance created.");
    }

    // Step 3: public static access method
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton(); // Lazy initialization
        }
        return instance;
    }
}
