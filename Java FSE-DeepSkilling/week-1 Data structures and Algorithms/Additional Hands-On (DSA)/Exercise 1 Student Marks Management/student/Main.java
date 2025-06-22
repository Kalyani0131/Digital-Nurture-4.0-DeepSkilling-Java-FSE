package com.dsa.student;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        manager.addStudent(new Student(1, "Sowmya", 85));
        manager.addStudent(new Student(2, "Bhagya", 92));
        manager.addStudent(new Student(3, "Eshwar", 78));
        manager.addStudent(new Student(4, "Mallesh", 88));
        manager.addStudent(new Student(5, "Kalyani", 95));

        System.out.println();
        manager.displayAll();

        System.out.println();
        manager.displayAverageMarks();

        System.out.println();
        manager.displayRankList();
    }
}
