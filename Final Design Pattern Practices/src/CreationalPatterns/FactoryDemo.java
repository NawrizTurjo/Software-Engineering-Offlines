package CreationalPatterns;
// Step 1: Define an interface
interface Shape {
    void draw();
}

// Step 2: Concrete implementations of Shape
class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Square implements Shape {
    public void draw() {
        System.out.println("Drawing a Square");
    }
}

// Step 3: Abstract Factory
abstract class ShapeFactory {
    public abstract Shape createShape();
}

// Step 4: Concrete Factories
class CircleFactory extends ShapeFactory {
    public Shape createShape() {
        return new Circle();
    }
}

class SquareFactory extends ShapeFactory {
    public Shape createShape() {
        return new Square();
    }
}

// Step 5: Client code
public class FactoryDemo {
    public static void main(String[] args) {
        ShapeFactory factory = new CircleFactory(); // Or new SquareFactory()
        Shape shape = factory.createShape();
        shape.draw(); // Output: Drawing a Circle
    }
}
