package StructuralPatterns;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EmployeeGraphPatternComposite {
    public static void main(String[] args) {
        Employee CEO = new Employee("John", "CEO", 30000);
        
        Employee headSales = new Employee("Robert", "Head Sales", 20000);
        Employee headMarketing = new Employee("Michel", "Head Marketing", 20000);
        
        Employee clerk1 = new Employee("Laura", "Marketing", 10000);
        Employee clerk2 = new Employee("Bob", "Marketing", 10000);
        
        Employee salesExecutive1 = new Employee("Richard", "Sales", 10000);
        Employee salesExecutive2 = new Employee("Rob", "Sales", 10000);
        
        CEO.add(headSales);
        CEO.add(headMarketing);
        
        headSales.add(salesExecutive1);
        headSales.add(salesExecutive2);
        
        headMarketing.add(clerk1);
        headMarketing.add(clerk2);
        
        // Print all employees of the organization
        System.out.println("Organization Structure:");
        System.out.println(CEO);
        
        for (Employee headEmployee : CEO.getSubordinates()) {
            System.out.println("  " + headEmployee);
            
            for (Employee employee : headEmployee.getSubordinates()) {
                System.out.println("    " + employee);
            }
        }
        
        System.out.println("\n--- Graph Algorithm Functions ---");
        
        // Count total employees (including CEO)
        System.out.println("Total number of employees: " + countTotalEmployees(CEO));
        
        // Count subordinates under an employee (excluding the employee)
        System.out.println("Number of employees under CEO: " + countSubordinates(CEO));
        System.out.println("Number of employees under Head Sales: " + countSubordinates(headSales));
        
        // Find maximum depth of the organization hierarchy
        System.out.println("Maximum depth of hierarchy: " + findMaxDepth(CEO));
        
        // Find employee by name using BFS
        String nameToFind = "Laura";
        Employee foundEmployee = findEmployeeByNameBFS(CEO, nameToFind);
        System.out.println("Found " + nameToFind + " using BFS: " + 
                          (foundEmployee != null ? foundEmployee : "Not found"));
        
        // Find employee by name using DFS
        nameToFind = "Rob";
        foundEmployee = findEmployeeByNameDFS(CEO, nameToFind);
        System.out.println("Found " + nameToFind + " using DFS: " + 
                          (foundEmployee != null ? foundEmployee : "Not found"));
        
        // Find employee with highest salary
        Employee highestPaid = findEmployeeWithHighestSalary(CEO);
        System.out.println("Highest paid employee: " + highestPaid);
        
        // Calculate total salary budget
        System.out.println("Total salary budget: $" + calculateTotalSalary(CEO));
        
        // Find all employees in a specific department using DFS
        String departmentToFind = "Marketing";
        System.out.println("\nEmployees in " + departmentToFind + " department:");
        findEmployeesByDepartmentDFS(CEO, departmentToFind);
    }
    
    // Count total number of employees using DFS (including the root)
    public static int countTotalEmployees(Employee root) {
        if (root == null) return 0;
        
        int count = 1; // Count the root employee
        
        for (Employee subordinate : root.getSubordinates()) {
            count += countTotalEmployees(subordinate);
        }
        
        return count;
    }
    
    // Count number of subordinates (excluding the employee themselves)
    public static int countSubordinates(Employee employee) {
        return countTotalEmployees(employee) - 1;
    }
    
    // Find maximum depth of the organizational hierarchy using DFS
    public static int findMaxDepth(Employee root) {
        if (root == null) return 0;
        if (root.getSubordinates().isEmpty()) return 1;
        
        int maxDepth = 0;
        
        for (Employee subordinate : root.getSubordinates()) {
            int depth = findMaxDepth(subordinate);
            maxDepth = Math.max(maxDepth, depth);
        }
        
        return maxDepth + 1;
    }
    
    // Find an employee by name using BFS
    public static Employee findEmployeeByNameBFS(Employee root, String name) {
        if (root == null) return null;
        
        Queue<Employee> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            Employee current = queue.poll();
            
            if (current.getName().equals(name)) {
                return current;
            }
            
            queue.addAll(current.getSubordinates());
        }
        
        return null;
    }
    
    // Find an employee by name using DFS
    public static Employee findEmployeeByNameDFS(Employee root, String name) {
        if (root == null) return null;
        
        if (root.getName().equals(name)) {
            return root;
        }
        
        for (Employee subordinate : root.getSubordinates()) {
            Employee result = findEmployeeByNameDFS(subordinate, name);
            if (result != null) {
                return result;
            }
        }
        
        return null;
    }
    
    // Find employee with highest salary using DFS
    public static Employee findEmployeeWithHighestSalary(Employee root) {
        if (root == null) return null;
        
        Employee highestPaid = root;
        
        for (Employee subordinate : root.getSubordinates()) {
            Employee highestPaidSubordinate = findEmployeeWithHighestSalary(subordinate);
            
            if (highestPaidSubordinate.getSalary() > highestPaid.getSalary()) {
                highestPaid = highestPaidSubordinate;
            }
        }
        
        return highestPaid;
    }
    
    // Calculate total salary of all employees using DFS
    public static double calculateTotalSalary(Employee root) {
        if (root == null) return 0;
        
        double totalSalary = root.getSalary();
        
        for (Employee subordinate : root.getSubordinates()) {
            totalSalary += calculateTotalSalary(subordinate);
        }
        
        return totalSalary;
    }
    
    // Find all employees in a specific department using DFS
    public static void findEmployeesByDepartmentDFS(Employee root, String department) {
        if (root == null) return;
        
        if (root.getDepartment().equals(department)) {
            System.out.println("  " + root);
        }
        
        for (Employee subordinate : root.getSubordinates()) {
            findEmployeesByDepartmentDFS(subordinate, department);
        }
    }
}

// The Employee class (Composite Pattern implementation)
class Employee {
    private String name;
    private String department;
    private double salary;
    private List<Employee> subordinates;
    
    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.subordinates = new ArrayList<>();
    }
    
    public void add(Employee e) {
        subordinates.add(e);
    }
    
    public void remove(Employee e) {
        subordinates.remove(e);
    }
    
    public List<Employee> getSubordinates() {
        return subordinates;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public double getSalary() {
        return salary;
    }
    
    @Override
    public String toString() {
        return "Employee: [Name: " + name + ", Department: " + department + ", Salary: $" + salary + "]";
    }
}

