package com.dsa.cart;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem(new CartItem("Laptop", 55000));
        cart.addItem(new CartItem("Mouse", 500));
        cart.addItem(new CartItem("Keyboard", 1200));
        cart.addItem(new CartItem("USB Cable", 300));

        System.out.println();
        cart.displayCart();

        System.out.println();
        cart.removeItem("Mouse");
        cart.displayCart();
    }
}
