package CreationalPatterns;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class EmployeeG {
    private String name;
    private String role;
    private int salary;
    private List<EmployeeG> subordinates;

    public EmployeeG(String name, String role, int salary) {
        this.name = name;
        this.role = role;
        this.salary = salary;
        this.subordinates = new ArrayList<>();
    }

    public void add(EmployeeG e) {
        subordinates.add(e);
    }

    public List<EmployeeG> getSubordinates() {
        return subordinates;
    }

    // DFS-based count
    public int countSubordinatesDFS() {
        int count = 0;
        for (EmployeeG subordinate : subordinates) {
            count += 1 + subordinate.countSubordinatesDFS();
        }
        return count;
    }

    // BFS-based count
    public int countSubordinatesBFS() {
        int count = 0;
        Queue<EmployeeG> queue = new LinkedList<>();
        queue.addAll(subordinates);
        
        while (!queue.isEmpty()) {
            EmployeeG current = queue.poll();
            count++;
            queue.addAll(current.getSubordinates());
        }
        return count;
    }

    @Override
    public String toString() {
        return "EmployeeG: [Name: " + name + ", Role: " + role + ", Salary: " + salary + "]";
    }
}

public class EmployeeGraphTest {
    public static void main(String[] args) {
        // Build organization hierarchy
        EmployeeG CEO = new EmployeeG("John", "CEO", 30000);
        EmployeeG headSales = new EmployeeG("Robert", "Head Sales", 20000);
        EmployeeG headMarketing = new EmployeeG("Michel", "Head Marketing", 20000);
        EmployeeG clerk1 = new EmployeeG("Laura", "Marketing", 10000);
        EmployeeG clerk2 = new EmployeeG("Bob", "Marketing", 10000);
        EmployeeG salesExecutive1 = new EmployeeG("Richard", "Sales", 10000);
        EmployeeG salesExecutive2 = new EmployeeG("Rob", "Sales", 10000);

        CEO.add(headSales);
        CEO.add(headMarketing);
        headSales.add(salesExecutive1);
        headSales.add(salesExecutive2);
        headMarketing.add(clerk1);
        headMarketing.add(clerk2);

        // Print hierarchy
        System.out.println("Organization Hierarchy:");
        System.out.println(CEO);
        for (EmployeeG head : CEO.getSubordinates()) {
            System.out.println("  ├─ " + head);
            for (EmployeeG emp : head.getSubordinates()) {
                System.out.println("  │  ├─ " + emp);
            }
        }

        // Calculate statistics
        System.out.println("\nSubordinate Counts:");
        System.out.println("CEO has " + CEO.countSubordinatesDFS() + " subordinates (DFS)");
        System.out.println("CEO has " + CEO.countSubordinatesBFS() + " subordinates (BFS)");
        System.out.println("Head Sales has " + headSales.countSubordinatesDFS() + " subordinates (DFS)");
        System.out.println("Head Marketing has " + headMarketing.countSubordinatesBFS() + " subordinates (BFS)");
        System.out.println("Clerk1 has " + clerk1.countSubordinatesDFS() + " subordinates (DFS)");
    }
}