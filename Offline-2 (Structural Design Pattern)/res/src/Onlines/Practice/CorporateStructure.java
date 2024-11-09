package Onlines.Practice;

import java.util.ArrayList;
import java.util.List;

interface Employeeee {
    int getSalary();

    void add(Employeeee employee); // Only applicable for Manager

    void remove(Employeeee employee); // Only applicable for Manager

    void showDetails();
}

class LesserEmp implements Employeeee {
    private String name;
    private int salary;

    public LesserEmp(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int getSalary() {
        return this.salary;
    }

    @Override
    public void add(Employeeee employee) {
        throw new UnsupportedOperationException("Not applicable for this class");
    }

    @Override
    public void remove(Employeeee employee) {
        throw new UnsupportedOperationException("Not applicable for this class");
    }

    @Override
    public void showDetails() {
        System.out.println(this.name + " has " + this.salary + " salary.");
    }

}

class HigherManager implements Employeeee {
    private String name;
    private int salary;
    List<Employeeee> staffs = new ArrayList<>();

    public HigherManager(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int getSalary() {
        int total = this.salary;
        for (Employeeee e : staffs) {
            total += e.getSalary();
        }
        return total;
    }

    @Override
    public void add(Employeeee employee) {
        staffs.add(employee);
    }

    @Override
    public void remove(Employeeee employee) {
        staffs.remove(employee);
    }

    @Override
    public void showDetails() {
        System.out.println(this.name + "-manager===");
        for (Employeeee e : staffs) {
            e.showDetails();
        }
        System.out.println("Team Salary " + this.getSalary());

    }

}

public class CorporateStructure {

    public static void main(String[] args) {
        // Create staff members
        Employeeee staff1 = new LesserEmp("a", 5000);
        Employeeee staff2 = new LesserEmp("b", 4000);
        Employeeee staff3 = new LesserEmp("c", 3000);

        // Create managers
        Employeeee manager1 = new HigherManager("m1", 10000);
        Employeeee manager2 = new HigherManager("m2", 12000);

        // Add staff to managers
        manager1.add(staff1);
        manager1.add(staff2);

        manager2.add(staff3);

        // Create the top-level manager (head of department)
        Employeeee headManager = new HigherManager("m3", 15000);
        headManager.add(manager1);
        headManager.add(manager2);

        // Calculate total salary for the team led by the head manager
        // System.out.println("Total Salary Expenditure: " + headManager.getSalary() + " units");
        headManager.showDetails();
    }
}
