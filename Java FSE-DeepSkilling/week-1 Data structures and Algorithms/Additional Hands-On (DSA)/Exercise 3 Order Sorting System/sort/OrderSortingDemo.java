package com.dsa.sort;

public class OrderSortingDemo {

    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-1-i; j++) {
                if (orders[j].getTotalPrice() < orders[j+1].getTotalPrice()) {
                    Order temp = orders[j];
                    orders[j] = orders[j+1];
                    orders[j+1] = temp;
                }
            }
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() > pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Order[] orders = {
            new Order("O1", "Kalyani", 5000),
            new Order("O2", "bhagya", 8000),
            new Order("O3", "eshwar", 3000)
        };

        System.out.println("Original orders:");
        for (Order o : orders) System.out.println(o);

        System.out.println("\nBubble Sort:");
        bubbleSort(orders);
        for (Order o : orders) System.out.println(o);

        // Reset orders for quick sort
        orders = new Order[]{
            new Order("O1", "Kalyani", 5000),
            new Order("O2", "bhagya", 8000),
            new Order("O3", "eshwar", 3000)
        };

        System.out.println("\nQuick Sort:");
        quickSort(orders, 0, orders.length - 1);
        for (Order o : orders) System.out.println(o);
    }
}
