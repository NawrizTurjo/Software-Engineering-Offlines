package StructuralPatterns;

// AbstractDecorator Pattern

interface iComponent {
    public void operation();
}

class ConcreteComponent implements iComponent {
    public void operation() {
        System.out.println("Concrete Component");
    }
}

abstract class AbstractDecorator implements iComponent {
    protected iComponent component;

    public AbstractDecorator(iComponent component) {
        this.component = component;
    }

    public void operation() {
        component.operation();
    }
}

class ConcreteDecoratorA extends AbstractDecorator {
    public ConcreteDecoratorA(iComponent component) {
        super(component);
    }

    public void operation() {
        super.operation();
        System.out.println("Concrete AbstractDecorator A");
    }
}

class ConcreteDecoratorB extends AbstractDecorator {
    public ConcreteDecoratorB(iComponent component) {
        super(component);
    }

    public void operation() {
        super.operation();
        System.out.println("Concrete AbstractDecorator B");
    }
}

public class DecoratorDemo {
    public static void main(String[] args) {
        // iComponent component = new ConcreteComponent();
        // component.operation();

        // iComponent decoratorA = new ConcreteDecoratorA(component);
        // decoratorA.operation();

        // iComponent decoratorB = new ConcreteDecoratorB(decoratorA);
        // decoratorB.operation();

        iComponent decoratorABABAABB = new ConcreteDecoratorB(
                new ConcreteDecoratorB(
                        new ConcreteDecoratorA(
                                new ConcreteDecoratorA(
                                        new ConcreteDecoratorB(
                                                new ConcreteDecoratorA(
                                                        new ConcreteDecoratorB(
                                                                new ConcreteDecoratorA(
                                                                        new ConcreteComponent()))))))));
        decoratorABABAABB.operation();
    }
}
