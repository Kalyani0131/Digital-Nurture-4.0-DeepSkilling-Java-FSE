package com.dsa.bank;

public class Main {
    public static void main(String[] args) {
        AccountManager manager = new AccountManager();

        manager.addAccount(new BankAccount(101, "Bhagya", 50000));
        manager.addAccount(new BankAccount(102, "Eshwar", 75000));
        manager.addAccount(new BankAccount(103, "Sowmya", 62000));

        System.out.println();
        manager.displayAll();

        System.out.println();
        manager.deleteAccount(102);
        manager.displayAll();
    }
}
