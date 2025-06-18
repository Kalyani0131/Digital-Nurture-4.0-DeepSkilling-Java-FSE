package com.singleton;

public class Main {

    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        if (s1 == s2) {
            System.out.println("Both references point to the same Singleton instance.");
        } else {
            System.out.println("Singleton failed! Different instances found.");
        }
    }
}
