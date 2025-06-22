package com.dsa.booking;

import java.util.LinkedList;
import java.util.Queue;

public class TicketBooking {
    Queue<String> queue = new LinkedList<>();

    public void bookTicket(String name) {
        queue.add(name);
        System.out.println("Ticket booked for: " + name);
    }

    public void serveNext() {
        if (queue.isEmpty()) {
            System.out.println("No more bookings to serve.");
            return;
        }
        String name = queue.poll();
        System.out.println("Serving ticket for: " + name);
    }

    public void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("No bookings in queue.");
            return;
        }
        System.out.println("=== Current Booking Queue ===");
        for (String name : queue) {
            System.out.println(name);
        }
    }
}
