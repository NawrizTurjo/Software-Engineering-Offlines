package CreationalPatterns.TemplateCode;

// Step 1: Define a common interface for products
interface Product {
    void use();
}

// Step 2: Implement concrete products
class ConcreteProductA implements Product {
    @Override
    public void use() {
        System.out.println("Using Product A");
    }
}

class ConcreteProductB implements Product {
    @Override
    public void use() {
        System.out.println("Using Product B");
    }
}

// Step 3: Create the Factory class
class ProductFactory {
    public static Product createProduct(String type) {
        switch (type) {
            case "A":
                return new ConcreteProductA();
            case "B":
                return new ConcreteProductB();
            default:
                throw new IllegalArgumentException("Unknown product type: " + type);
        }
    }
}

// Step 4: Demonstrate the Factory Pattern
public class FactoryPatternDemo {
    public static void main(String[] args) {
        Product productA = ProductFactory.createProduct("A");
        productA.use();

        Product productB = ProductFactory.createProduct("B");
        productB.use();
    }
}

