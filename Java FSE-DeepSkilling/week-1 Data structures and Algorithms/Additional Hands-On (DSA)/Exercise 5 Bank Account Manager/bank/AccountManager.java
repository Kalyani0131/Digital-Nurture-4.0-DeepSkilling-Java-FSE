package com.dsa.bank;

import java.util.HashMap;

public class AccountManager {
    HashMap<Integer, BankAccount> accounts = new HashMap<>();

    public void addAccount(BankAccount acc) {
        accounts.put(acc.accNo, acc);
        System.out.println("Account added for: " + acc.accHolder);
    }

    public void displayAll() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts to display.");
            return;
        }
        System.out.println("=== All Accounts ===");
        for (BankAccount acc : accounts.values()) {
            acc.display();
        }
    }

    public void deleteAccount(int accNo) {
        if (accounts.containsKey(accNo)) {
            accounts.remove(accNo);
            System.out.println("Deleted account: " + accNo);
        } else {
            System.out.println("Account not found: " + accNo);
        }
    }
}
