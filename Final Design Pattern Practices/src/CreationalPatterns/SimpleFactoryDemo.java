package CreationalPatterns;
// Step 1: Define an interface
interface ShapeSimple {
    void draw();
}

// Step 2: Concrete implementations of Shape
class CircleSimple implements ShapeSimple {
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class SquareSimple implements ShapeSimple {
    public void draw() {
        System.out.println("Drawing a Square");
    }
}

// Step 3: Simple Factory class
class SimpleShapeFactory {
    public static ShapeSimple createShape(String shapeType) {
        if ("circle".equalsIgnoreCase(shapeType)) {
            return new CircleSimple();
        } else if ("square".equalsIgnoreCase(shapeType)) {
            return new SquareSimple();
        } else {
            throw new IllegalArgumentException("Unknown shape type: " + shapeType);
        }
    }
}

// Step 4: Client code
public class SimpleFactoryDemo {
    public static void main(String[] args) {
        ShapeSimple shape = SimpleShapeFactory.createShape("circle");
        shape.draw(); // Output: Drawing a Circle
    }
}
