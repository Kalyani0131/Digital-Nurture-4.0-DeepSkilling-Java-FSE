package com.dsa.inventory;

public class InventoryTest {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        Product p1 = new Product("P001", "Mouse", 50, 499.99);
        Product p2 = new Product("P002", "Keyboard", 30, 899.99);

        inventory.addProduct(p1);
        inventory.addProduct(p2);

        inventory.displayInventory();

        inventory.updateProduct("P001", 60, 479.99);
        inventory.deleteProduct("P002");

        inventory.displayInventory();
    }
}
