package com.dsa.employees;

public class EmployeeTest {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(5);

        manager.addEmployee(new Employee("E1", "Kalyani", "Developer", 60000));
        manager.addEmployee(new Employee("E2", "sowmya", "Tester", 50000));

        System.out.println("All employees:");
        manager.traverseEmployees();

        System.out.println("Search E2: " + manager.searchEmployee("E2"));
        manager.deleteEmployee("E2");

        System.out.println("After deletion:");
        manager.traverseEmployees();
    }
}
