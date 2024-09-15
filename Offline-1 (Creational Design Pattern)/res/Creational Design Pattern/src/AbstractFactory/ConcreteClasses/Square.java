package AbstractFactory.ConcreteClasses;

import AbstractFactory.Interfaces.Shape;

public class Square implements Shape {
    @Override
    public void draw() {
       System.out.println("Inside Square::draw() method.");
    }
 }