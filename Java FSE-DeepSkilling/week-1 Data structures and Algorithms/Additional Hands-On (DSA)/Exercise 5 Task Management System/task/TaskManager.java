package com.dsa.task;

public class TaskManager {
    private TaskNode head;

    public void addTask(Task task) {
        TaskNode node = new TaskNode(task);
        node.next = head;
        head = node;
        System.out.println("Added: " + task);
    }

    public Task searchTask(String id) {
        TaskNode current = head;
        while (current != null) {
            if (current.task.getTaskId().equals(id)) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    public void traverseTasks() {
        TaskNode current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    public void deleteTask(String id) {
        TaskNode current = head;
        TaskNode prev = null;

        while (current != null) {
            if (current.task.getTaskId().equals(id)) {
                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }
                System.out.println("Removed: " + current.task);
                return;
            }
            prev = current;
            current = current.next;
        }
        System.out.println("Task not found.");
    }
}
