package com.dsa.task;

public class TaskTest {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        manager.addTask(new Task("T1", "Design UI", "Pending"));
        manager.addTask(new Task("T2", "Write Backend", "In Progress"));

        System.out.println("All tasks:");
        manager.traverseTasks();

        System.out.println("Search T1: " + manager.searchTask("T1"));
        manager.deleteTask("T1");

        System.out.println("After deletion:");
        manager.traverseTasks();
    }
}