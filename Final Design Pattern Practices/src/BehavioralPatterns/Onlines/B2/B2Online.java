package BehavioralPatterns.Onlines.B2;

import java.util.HashMap;
import java.util.Map;

// Step 1: Define the Mediator Interface
interface Mediator {
    void notify(String source, String message);
    void registerDepartment(String departmentName, Department department);
}

// Step 2: Define the Department Interface
interface Department {
    void handleRequest(String message);
}

// Step 3: Implement Concrete Departments
class InventoryDepartment implements Department {
    @Override
    public void handleRequest(String message) {
        System.out.println("Inventory Department handling: " + message);
    }
}

class BillingDepartment implements Department {
    @Override
    public void handleRequest(String message) {
        System.out.println("Billing Department handling: " + message);
    }
}

class ShippingDepartment implements Department {
    @Override
    public void handleRequest(String message) {
        System.out.println("Shipping Department handling: " + message);
    }
}

// Step 4: Implement the Concrete Mediator
class CustomerServiceMediator implements Mediator {
    private Map<String, Department> departments = new HashMap<>();

    @Override
    public void notify(String source, String message) {
        System.out.println("Mediator received a request from " + source + ": " + message);

        // Route the message based on keywords
        if (message.contains("inventory")) {
            departments.get("inventory").handleRequest(message);
        } else if (message.contains("billing")) {
            departments.get("billing").handleRequest(message);
        } else if (message.contains("shipping")) {
            departments.get("shipping").handleRequest(message);
        } else {
            System.out.println("Mediator: No suitable department found for the request.");
        }
    }

    @Override
    public void registerDepartment(String departmentName, Department department) {
        departments.put(departmentName, department);
    }
}

// Step 5: Create Communication Tools (Live Chat, Email, Phone Support)
class CommunicationTool {
    private String name;
    private Mediator mediator;

    public CommunicationTool(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public void sendMessage(String message) {
        System.out.println(name + " sending message: " + message);
        mediator.notify(name, message);
    }
}

// Step 6: Main class to demonstrate the system
public class B2Online {
    public static void main(String[] args) {
        // Create a mediator
        Mediator mediator = new CustomerServiceMediator();

        // Register departments with the mediator
        mediator.registerDepartment("inventory", new InventoryDepartment());
        mediator.registerDepartment("billing", new BillingDepartment());
        mediator.registerDepartment("shipping", new ShippingDepartment());

        // Create communication tools
        CommunicationTool liveChat = new CommunicationTool("Live Chat", mediator);
        CommunicationTool email = new CommunicationTool("Email", mediator);
        CommunicationTool phoneSupport = new CommunicationTool("Phone Support", mediator);

        // Simulate customer inquiries
        liveChat.sendMessage("Need help with inventory stock check.");
        email.sendMessage("Billing issue with recent order.");
        phoneSupport.sendMessage("Shipping status of order #1234.");
    }
}

