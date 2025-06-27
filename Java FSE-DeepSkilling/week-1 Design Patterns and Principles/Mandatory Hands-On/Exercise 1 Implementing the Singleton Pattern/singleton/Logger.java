package com.design.singleton;

public class Logger {

    // Single instance - private and static
    private static Logger instance;

    // Private constructor
    private Logger() {
        System.out.println("Logger initialized");
    }

    // Public method to provide access
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Example log method
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}
