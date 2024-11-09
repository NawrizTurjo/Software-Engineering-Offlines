package Onlines.Practice;

import java.util.ArrayList;
import java.util.List;

interface Employee {
    void showDetails();

    int getSalary();

    String getName();
}

class RegularEmployee implements Employee {
    private String name;
    private int salary;

    public RegularEmployee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public void showDetails() {
        System.out.println("Employee: " + name + ", Salary: " + salary);
    }

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public String getName() {
        return this.name;
    }
}

class Manager implements Employee {
    private String name;
    private int salary;
    private List<Employee> subordinates = new ArrayList<>();

    public Manager(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public void addSubordinate(Employee employee) {
        subordinates.add(employee);
    }

    public void removeSubordinate(Employee employee) {
        subordinates.remove(employee);
    }

    @Override
    public void showDetails() {
        System.out.println("Manager: " + name + ", Salary: " + salary);
        for (Employee employee : subordinates) {
            employee.showDetails();
        }
    }

    @Override
    public int getSalary() {
        int totalSalary = salary;
        for (Employee employee : subordinates) {
            totalSalary += employee.getSalary();
        }
        return totalSalary;
    }

    @Override
    public String getName() {
        return this.name;
    }
}

public class Organization {
    public static void main(String[] args) {
        Manager manager1 = new Manager("Alice", 5000);
        Manager manager2 = new Manager("Bob", 4000);

        RegularEmployee employee1 = new RegularEmployee("Charlie", 2000);
        RegularEmployee employee2 = new RegularEmployee("David", 2500);
        RegularEmployee employee3 = new RegularEmployee("Eve", 3000);

        manager1.addSubordinate(employee1);
        manager1.addSubordinate(employee2);

        manager2.addSubordinate(employee3);

        manager1.showDetails();
        System.out.println("Total Salary under " + manager1.getName() + " " + manager1.getSalary());
    }
}
