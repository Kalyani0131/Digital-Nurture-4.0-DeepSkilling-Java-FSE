package com.dsa.student;

import java.util.*;

public class StudentManager {
    private HashMap<Integer, Student> students = new HashMap<>();

    public void addStudent(Student s) {
        students.put(s.rollNo, s);
        System.out.println("Added student: " + s.name);
    }

    public void displayAll() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }
        System.out.println("=== All Students ===");
        for (Student s : students.values()) {
            s.display();
        }
    }

    public void displayAverageMarks() {
        if (students.isEmpty()) {
            System.out.println("No data to compute average.");
            return;
        }
        int total = 0;
        for (Student s : students.values()) {
            total += s.marks;
        }
        double avg = (double) total / students.size();
        System.out.printf("Average Marks: %.2f\n", avg);
    }

    public void displayRankList() {
        if (students.isEmpty()) {
            System.out.println("No data for rank list.");
            return;
        }
        List<Student> rankList = new ArrayList<>(students.values());
        rankList.sort((a, b) -> b.marks - a.marks);
        System.out.println("=== Rank List ===");
        int rank = 1;
        for (Student s : rankList) {
            System.out.println("Rank " + rank + ": " + s.name + " (" + s.marks + " marks)");
            rank++;
        }
    }
}
