package com.dsa.seating;

import java.util.ArrayList;

public class SeatingPlanner {
    private String[][] seats;
    private ArrayList<String> students;

    public SeatingPlanner(int rows, int cols) {
        seats = new String[rows][cols];
        students = new ArrayList<>();
    }

    public void addStudent(String name) {
        students.add(name);
        System.out.println("Added student: " + name);
    }

    public void assignSeats() {
        int index = 0;
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (index < students.size()) {
                    seats[i][j] = students.get(index);
                    index++;
                } else {
                    seats[i][j] = "Empty";
                }
            }
        }
    }

    public void displaySeatingPlan() {
        System.out.println("=== Exam Seating Plan ===");
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                System.out.printf("%-12s", seats[i][j]);
            }
            System.out.println();
        }
    }
}
