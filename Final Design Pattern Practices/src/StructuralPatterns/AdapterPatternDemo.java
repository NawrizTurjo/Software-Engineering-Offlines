package StructuralPatterns;

interface iRectangle {
    public void setLength(double length);

    public void setWidth(double width);

    public double getLength();

    public double getWidth();
}

class RectangleAdd implements iRectangle {
    private double length;
    private double width;

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }
}

class Calculator {
    public double getArea(iRectangle rectangle) {
        return rectangle.getLength() * rectangle.getWidth();
    }
}

interface iTriangle {
    public void setBase(double base);

    public void setHeight(double height);

    public double getBase();

    public double getHeight();
}

class TriangleAdd implements iTriangle {
    private double base;
    private double height;

    public void setBase(double base) {
        this.base = base;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }
}

class CalculatorTriangleAdapter {
    public double getArea(iTriangle triangle) {
        iRectangle r = new RectangleAdd();
        r.setLength(triangle.getBase());
        r.setWidth(triangle.getHeight() / 2);
        Calculator c = new Calculator();
        return c.getArea(r);
    }
}

public class AdapterPatternDemo {
    public static void main(String[] args) {
        iTriangle triangle = new TriangleAdd();
        triangle.setBase(20);
        triangle.setHeight(10);
        CalculatorTriangleAdapter adapter = new CalculatorTriangleAdapter();
        System.out.println("Area of Triangle: " + adapter.getArea(triangle));
    }
}
