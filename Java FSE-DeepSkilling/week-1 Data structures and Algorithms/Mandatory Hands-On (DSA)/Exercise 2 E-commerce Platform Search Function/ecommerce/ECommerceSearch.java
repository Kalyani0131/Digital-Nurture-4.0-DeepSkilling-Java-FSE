package com.ecommerce;

import java.util.Arrays;

public class ECommerceSearch {

    // Binary search to find a product in the sorted list
    public static int binarySearch(String[] products, String target) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int cmp = products[mid].compareToIgnoreCase(target);

            if (cmp == 0) {
                return mid; // found
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // not found
    }

    public static void main(String[] args) {
        String[] products = {
            "Mobile",
            "Charger",
            "Laptop",
            "Tablet",
            "Headphones",
            "Smartwatch",
            "Camera"
        };

        // Step 1: Sort the product list
        Arrays.sort(products);
        System.out.println("Sorted Products: " + Arrays.toString(products));

        // Step 2: Search for a product
        String targetProduct = "Tablet";
        int index = binarySearch(products, targetProduct);

        if (index != -1) {
            System.out.println("'" + targetProduct + "' found at index " + index);
        } else {
            System.out.println("'" + targetProduct + "' not found!");
        }
    }
}
