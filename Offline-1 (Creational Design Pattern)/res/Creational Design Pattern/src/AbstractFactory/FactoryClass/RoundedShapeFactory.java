package AbstractFactory.FactoryClass;

import AbstractFactory.AbstractFactoryClass.AbstractFactory;
import AbstractFactory.ConcreteClasses.RoundedRectangle;
import AbstractFactory.ConcreteClasses.RoundedSquare;
import AbstractFactory.Interfaces.Shape;

public class RoundedShapeFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shapeType){    
       if(shapeType.equalsIgnoreCase("RECTANGLE")){
          return new RoundedRectangle();         
       }else if(shapeType.equalsIgnoreCase("SQUARE")){
          return new RoundedSquare();
       }	 
       return null;
    }
 }