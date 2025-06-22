package com.dsa.booking;

public class Main {
    public static void main(String[] args) {
        TicketBooking booking = new TicketBooking();

        booking.bookTicket("Kalyani");
        booking.bookTicket("Sowmya");
        booking.bookTicket("Bhagya");
        booking.bookTicket("Eshwar");

        System.out.println();
        booking.displayQueue();

        System.out.println();
        booking.serveNext();
        booking.displayQueue();

        System.out.println();
        booking.serveNext();
        booking.displayQueue();
    }
}
