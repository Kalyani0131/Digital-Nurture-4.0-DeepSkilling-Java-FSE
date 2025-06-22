package com.pattern.mvc;

public class StudentController {
    private Student student;
    private StudentView view;

    public StudentController(Student student, StudentView view) {
        this.student = student;
        this.view = view;
    }

    public void updateView() {
        view.displayStudentDetails(student.getName(), student.getRollNo());
    }
}
