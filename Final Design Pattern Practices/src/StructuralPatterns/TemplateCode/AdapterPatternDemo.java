package StructuralPatterns.TemplateCode;

// Step 1: Define the Target interface
interface Target {
    void request();
}

// Step 2: Create an Adaptee class with an incompatible interface
class Adaptee {
    public void specificRequest() {
        System.out.println("Called specificRequest from Adaptee");
    }
}

// Step 3: Create an Adapter class that implements the Target interface
class Adapter implements Target {
    private Adaptee adaptee;

    // Constructor to accept the Adaptee object
    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    // Translate the Target request to Adaptee's specificRequest
    @Override
    public void request() {
        adaptee.specificRequest();
    }
}

// Step 4: Demonstrate the Adapter Pattern
public class AdapterPatternDemo {
    public static void main(String[] args) {
        // Create an instance of Adaptee
        Adaptee adaptee = new Adaptee();

        // Create an Adapter to make Adaptee compatible with Target
        Target target = new Adapter(adaptee);

        // Use the Target interface to call the method
        target.request();
    }
}
