package com.dsa.seating;

public class Main {
    public static void main(String[] args) {
        SeatingPlanner planner = new SeatingPlanner(3, 4);

        planner.addStudent("Kalyani");
        planner.addStudent("Sowmya");
        planner.addStudent("Eshwar");
        planner.addStudent("Bhagya");
        planner.addStudent("Akalya");
        planner.addStudent("Laxmi");
        planner.addStudent("Somi");

        System.out.println();
        planner.assignSeats();

        planner.displaySeatingPlan();
    }
}
