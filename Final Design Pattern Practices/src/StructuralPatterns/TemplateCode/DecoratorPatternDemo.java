package StructuralPatterns.TemplateCode;

// Step 1: Define the Component interface
interface Component {
    void operation();
}

// Step 2: Create Concrete Component
class ConcreteComponent implements Component {
    @Override
    public void operation() {
        System.out.println("Concrete Component operation");
    }
}

// Step 3: Create an abstract Decorator class
abstract class Decorator implements Component {
    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}

// Step 4: Create Concrete Decorators
class ConcreteDecoratorA extends Decorator {
    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        System.out.println("ConcreteDecoratorA added behavior");
    }
}

class ConcreteDecoratorB extends Decorator {
    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        System.out.println("ConcreteDecoratorB added behavior");
    }
}

// Step 5: Demonstrate the Decorator Pattern
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        // Create a concrete component
        Component component = new ConcreteComponent();

        // Decorate the component with ConcreteDecoratorA
        Component decoratorA = new ConcreteDecoratorA(component);

        // Further decorate with ConcreteDecoratorB
        Component decoratorB = new ConcreteDecoratorB(decoratorA);

        // Execute the operation
        decoratorB.operation();
    }
}

