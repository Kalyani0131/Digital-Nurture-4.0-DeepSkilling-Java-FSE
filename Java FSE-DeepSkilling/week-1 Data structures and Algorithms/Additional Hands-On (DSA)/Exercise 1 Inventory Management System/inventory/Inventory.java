package com.dsa.inventory;

import java.util.HashMap;

public class Inventory {
    private HashMap<String, Product> products = new HashMap<>();

    public void addProduct(Product p) {
        products.put(p.getProductId(), p);
        System.out.println("Product added: " + p);
    }

    public void updateProduct(String productId, int quantity, double price) {
        Product p = products.get(productId);
        if (p != null) {
            p.setQuantity(quantity);
            p.setPrice(price);
            System.out.println("Product updated: " + p);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(String productId) {
        Product removed = products.remove(productId);
        if (removed != null) {
            System.out.println("Product removed: " + removed);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void displayInventory() {
        for (Product p : products.values()) {
            System.out.println(p);
        }
    }
}
