package com.dsa.bank;

public class BankAccount {
    int accNo;
    String accHolder;
    double balance;

    public BankAccount(int accNo, String accHolder, double balance) {
        this.accNo = accNo;
        this.accHolder = accHolder;
        this.balance = balance;
    }

    public void display() {
        System.out.println("Acc No: " + accNo + ", Holder: " + accHolder + ", Balance: Rs." + balance);
    }
}
