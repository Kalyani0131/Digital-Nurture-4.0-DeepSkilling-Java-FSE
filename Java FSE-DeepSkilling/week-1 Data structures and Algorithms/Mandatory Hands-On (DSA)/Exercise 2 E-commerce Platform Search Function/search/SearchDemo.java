package com.dsa.search;

import java.util.Arrays;
import java.util.Comparator;

public class SearchDemo {

    public static Product linearSearch(Product[] products, String name) {
        for (Product p : products) {
            if (p.getProductName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String name) {
        int left = 0, right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = products[mid].getProductName().compareToIgnoreCase(name);
            if (cmp == 0) return products[mid];
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product("P1", "Laptop", "Electronics"),
            new Product("P2", "Mobile", "Electronics"),
            new Product("P3", "Shoes", "Footwear"),
            new Product("P4", "Tablet", "Electronics")
        };

        System.out.println("Linear search result: " +
            linearSearch(products, "Shoes"));

        Arrays.sort(products, Comparator.comparing(Product::getProductName, String.CASE_INSENSITIVE_ORDER));
        System.out.println("Binary search result: " +
            binarySearch(products, "Tablet"));
    }
}
