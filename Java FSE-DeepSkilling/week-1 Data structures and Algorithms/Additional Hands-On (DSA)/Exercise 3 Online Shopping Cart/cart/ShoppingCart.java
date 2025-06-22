package com.dsa.cart;

import java.util.LinkedList;

public class ShoppingCart {
    LinkedList<CartItem> cart = new LinkedList<>();

    public void addItem(CartItem item) {
        cart.add(item);
        System.out.println("Added: " + item.name);
    }

    public void removeItem(String name) {
        boolean removed = cart.removeIf(item -> item.name.equalsIgnoreCase(name));
        if (removed) {
            System.out.println("Removed: " + name);
        } else {
            System.out.println(name + " not found in cart.");
        }
    }

    public void displayCart() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        System.out.println("=== Shopping Cart ===");
        double total = 0;
        for (CartItem item : cart) {
            item.display();
            total += item.price;
        }
        System.out.printf("Total: Rs. %.2f\n", total);
    }
}
