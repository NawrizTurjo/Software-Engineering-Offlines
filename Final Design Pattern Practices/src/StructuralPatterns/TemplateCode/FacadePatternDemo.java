package StructuralPatterns.TemplateCode;

// Subsystem classes with their own specific operations
class SubsystemA {
    public void operationA() {
        System.out.println("SubsystemA: Executing operation A.");
    }
}

class SubsystemB {
    public void operationB() {
        System.out.println("SubsystemB: Executing operation B.");
    }
}

class SubsystemC {
    public void operationC() {
        System.out.println("SubsystemC: Executing operation C.");
    }
}

// Facade class that provides a simplified interface
class Facade {
    private SubsystemA subsystemA;
    private SubsystemB subsystemB;
    private SubsystemC subsystemC;

    public Facade() {
        subsystemA = new SubsystemA();
        subsystemB = new SubsystemB();
        subsystemC = new SubsystemC();
    }

    // A high-level method that coordinates operations across subsystems
    public void performOperation1() {
        System.out.println("Facade: Performing operation 1.");
        subsystemA.operationA();
        subsystemB.operationB();
    }

    // Another high-level method that coordinates operations across subsystems
    public void performOperation2() {
        System.out.println("Facade: Performing operation 2.");
        subsystemB.operationB();
        subsystemC.operationC();
    }

    // A high-level method that coordinates operations across subsystems
    public void performOperation3() {
        System.out.println("Facade: Performing operation 3.");
        subsystemA.operationA();
        subsystemC.operationC();
    }
}

// Client code using the Facade
public class FacadePatternDemo {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.performOperation1();
        facade.performOperation2();
        facade.performOperation3();
    }
}
