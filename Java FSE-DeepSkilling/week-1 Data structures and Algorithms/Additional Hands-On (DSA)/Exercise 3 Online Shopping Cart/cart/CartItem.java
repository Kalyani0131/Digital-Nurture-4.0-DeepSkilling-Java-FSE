package com.dsa.cart;

public class CartItem {
    String name;
    double price;

    public CartItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void display() {
        System.out.println("Item: " + name + ", Price: Rs." + price);
    }
}
