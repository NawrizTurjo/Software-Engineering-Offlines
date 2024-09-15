package AbstractFactory.FactoryClass;

import AbstractFactory.AbstractFactoryClass.AbstractFactory;
import AbstractFactory.ConcreteClasses.Rectangle;
import AbstractFactory.ConcreteClasses.Square;
import AbstractFactory.Interfaces.Shape;

public class ShapeFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shapeType){    
       if(shapeType.equalsIgnoreCase("RECTANGLE")){
          return new Rectangle();         
       }else if(shapeType.equalsIgnoreCase("SQUARE")){
          return new Square();
       }	 
       return null;
    }
 }
