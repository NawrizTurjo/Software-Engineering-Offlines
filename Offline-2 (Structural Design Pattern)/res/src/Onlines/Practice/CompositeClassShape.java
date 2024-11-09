package Onlines.Practice;

import java.util.ArrayList;
import java.util.List;

interface Shape1 {
    void draw();
}

class Circle1 implements Shape1 {

    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }

}

class Square1 implements Shape1 {

    @Override
    public void draw() {
        System.out.println("Drawing Square");
    }

}

class Linee implements Shape1 {

    @Override
    public void draw() {
        System.out.println("Drawing Line");
    }

}

class OnekgulaShapes implements Shape1 {
    List<Shape1> shapes = new ArrayList<>();

    public void addShape(Shape1 shape) {
        shapes.add(shape);
    }

    public void removeShape(Shape1 shape) {
        shapes.remove(shape);
    }

    @Override
    public void draw() {
        System.out.println("Onekgula Shape");
        for (Shape1 shape : shapes) {
            shape.draw();
        }
    }

}

public class CompositeClassShape {
    public static void main(String[] args) {
        Shape1 circle = new Circle1();
        Shape1 square = new Square1();
        Shape1 line = new Linee();

        OnekgulaShapes shapes = new OnekgulaShapes();

        shapes.addShape(circle);
        shapes.addShape(square);
        shapes.addShape(line);

        OnekgulaShapes shapes2 = new OnekgulaShapes();
        shapes2.addShape(circle);
        shapes2.addShape(shapes);

        shapes2.draw();

    }
}
