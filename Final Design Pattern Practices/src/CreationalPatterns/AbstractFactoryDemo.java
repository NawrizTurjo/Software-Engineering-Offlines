package CreationalPatterns;
interface ShapeAbs {
    void draw();
}

class RectancleAbs implements ShapeAbs {
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

class SquareAbs implements ShapeAbs {
    public void draw() {
        System.out.println("Drawing a Square");
    }
}

class RoundedRectangleAbs implements ShapeAbs {
    public void draw() {
        System.out.println("Drawing a RoundedRectangle");
    }
}

class RoundedSquareAbs implements ShapeAbs {
    public void draw() {
        System.out.println("Drawing a RoundedSquare");
    }
}

abstract class AbstractFactory {
    public abstract ShapeAbs createShape(String shapeType);
}

class ShapeFactoryAbs extends AbstractFactory {
    public ShapeAbs createShape(String shapeType) {
        if ("rectangle".equalsIgnoreCase(shapeType)) {
            return new RectancleAbs();
        } else if ("square".equalsIgnoreCase(shapeType)) {
            return new SquareAbs();
        } else {
            throw new IllegalArgumentException("Unknown shape type: " + shapeType);
        }
    }
}

class RoundedShapeFactoryAbs extends AbstractFactory {
    public ShapeAbs createShape(String shapeType) {
        if ("rectangle".equalsIgnoreCase(shapeType)) {
            return new RoundedRectangleAbs();
        } else if ("square".equalsIgnoreCase(shapeType)) {
            return new RoundedSquareAbs();
        } else {
            throw new IllegalArgumentException("Unknown shape type: " + shapeType);
        }
    }
}

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        AbstractFactory factory = new ShapeFactoryAbs(); // Or new RoundedShapeFactory()
        ShapeAbs shape = factory.createShape("rectangle");
        shape.draw(); // Output: Drawing a Rectangle

        factory = new RoundedShapeFactoryAbs();
        shape = factory.createShape("rectangle");
        shape.draw(); // Output: Drawing a RoundedRectangle
    }
}
