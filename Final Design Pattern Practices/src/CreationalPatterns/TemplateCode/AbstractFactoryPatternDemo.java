package CreationalPatterns.TemplateCode;

// Step 1: Define interfaces for product families
interface ProductA {
    void use();
}

interface ProductB {
    void use();
}

// Step 2: Implement concrete products
class ConcreteProductA1 implements ProductA {
    @Override
    public void use() {
        System.out.println("Using Product A1");
    }
}

class ConcreteProductA2 implements ProductA {
    @Override
    public void use() {
        System.out.println("Using Product A2");
    }
}

class ConcreteProductB1 implements ProductB {
    @Override
    public void use() {
        System.out.println("Using Product B1");
    }
}

class ConcreteProductB2 implements ProductB {
    @Override
    public void use() {
        System.out.println("Using Product B2");
    }
}

// Step 3: Create an Abstract Factory interface
interface AbstractFactory {
    ProductA createProductA();
    ProductB createProductB();
}

// Step 4: Implement concrete factories
class Factory1 implements AbstractFactory {
    @Override
    public ProductA createProductA() {
        return new ConcreteProductA1();
    }

    @Override
    public ProductB createProductB() {
        return new ConcreteProductB1();
    }
}

class Factory2 implements AbstractFactory {
    @Override
    public ProductA createProductA() {
        return new ConcreteProductA2();
    }

    @Override
    public ProductB createProductB() {
        return new ConcreteProductB2();
    }
}

// Step 5: Demonstrate the Abstract Factory Pattern
public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        // Using Factory1
        AbstractFactory factory1 = new Factory1();
        ProductA productA1 = factory1.createProductA();
        ProductB productB1 = factory1.createProductB();
        productA1.use();
        productB1.use();

        // Using Factory2
        AbstractFactory factory2 = new Factory2();
        ProductA productA2 = factory2.createProductA();
        ProductB productB2 = factory2.createProductB();
        productA2.use();
        productB2.use();
    }
}

