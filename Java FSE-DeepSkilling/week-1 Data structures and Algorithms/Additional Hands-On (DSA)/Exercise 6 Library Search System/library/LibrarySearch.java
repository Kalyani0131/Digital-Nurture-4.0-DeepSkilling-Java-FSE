package com.dsa.library;

import java.util.Arrays;
import java.util.Comparator;

public class LibrarySearch {

    public static Book linearSearch(Book[] books, String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }

    public static Book binarySearch(Book[] books, String title) {
        int left = 0, right = books.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = books[mid].getTitle().compareToIgnoreCase(title);
            if (cmp == 0) return books[mid];
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book("B1", "Java Programming"),
            new Book("B2", "Data Structures"),
            new Book("B3", "Algorithms"),
            new Book("B4", "Operating Systems")
        };

        System.out.println("Linear search result: " + linearSearch(books, "Algorithms"));

        Arrays.sort(books, Comparator.comparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER));
        System.out.println("Binary search result: " + binarySearch(books, "Operating Systems"));
    }
}
