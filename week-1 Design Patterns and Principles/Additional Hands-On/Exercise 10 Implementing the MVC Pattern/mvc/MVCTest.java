package com.pattern.mvc;

public class MVCTest {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("sowmya");
        student.setId("S123");
        student.setGrade("A");

        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);

        controller.updateView();

        controller.setStudentName("Kalyani");
        controller.setStudentGrade("A+");
        controller.updateView();
    }
}
