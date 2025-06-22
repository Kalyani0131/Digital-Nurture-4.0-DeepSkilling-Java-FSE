package com.pattern.mvc;

public class Main {
    public static void main(String[] args) {
        Student model = new Student("Kalyani", "61");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);
        controller.updateView();
    }
}
