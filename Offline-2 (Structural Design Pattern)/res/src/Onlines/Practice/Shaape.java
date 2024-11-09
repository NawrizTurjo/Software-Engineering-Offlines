package Onlines.Practice;

// Legacy Circle and Rectangle classes, which we cannot modify
class Circle {
    public void renderCircle() {
        System.out.println("Drawing a circle");
    }
}

class Rectangle {
    public void renderRectangle() {
        System.out.println("Drawing a rectangle");
    }
}

// Client Interface expected by the application
interface Shape {
    void draw();
}

// Application class that depends on the Shape interface
class DrawingApp {
    private Shape shape;

    public DrawingApp(Shape shape) {
        this.shape = shape;
    }

    public void drawShape() {
        shape.draw();
    }
}

class CircleAdapter implements Shape {
    Circle circle;

    public CircleAdapter(Circle circle) {
        this.circle = circle;
    }

    @Override
    public void draw() {
        circle.renderCircle();
    }
}

class RectangleAdapter implements Shape {
    Rectangle rectangle;

    public RectangleAdapter(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    @Override
    public void draw() {
        rectangle.renderRectangle();
    }
}

// Main Class
public class Shaape {
    public static void main(String[] args) {
        // Legacy services
        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();

        // Adapter for Circle
        Shape circleShape = new CircleAdapter(circle);

        // Adapter for Rectangle
        Shape rectangleShape = new RectangleAdapter(rectangle);

        DrawingApp app = new DrawingApp(circleShape);
        app.drawShape(); // Output: Drawing a circle

        app = new DrawingApp(rectangleShape);
        app.drawShape(); // Output: Drawing a rectangle
    }
}
