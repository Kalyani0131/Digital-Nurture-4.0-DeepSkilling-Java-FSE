package com.dsa.ecommerce;

import java.util.Arrays;

public class ECommerceSearch {

    
    public static int binarySearch(String[] products, String target) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int cmp = products[mid].compareToIgnoreCase(target);

            if (cmp == 0) {
                return mid; 
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; 
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

        
        Arrays.sort(products);
        System.out.println("Sorted Products: " + Arrays.toString(products));

       
        String targetProduct = "Tablet";
        int index = binarySearch(products, targetProduct);

        if (index != -1) {
            System.out.println("'" + targetProduct + "' found at index " + index);
        } else {
            System.out.println("'" + targetProduct + "' not found!");
        }
    }
}
