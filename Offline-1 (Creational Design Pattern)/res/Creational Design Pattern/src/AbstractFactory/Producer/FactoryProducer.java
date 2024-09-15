package AbstractFactory.Producer;

import AbstractFactory.AbstractClass.AbstractFactory;
import AbstractFactory.FactoryClass.RoundedShapeFactory;
import AbstractFactory.FactoryClass.ShapeFactory;

public class FactoryProducer {
    public static AbstractFactory getFactory(boolean rounded){   
       if(rounded){
          return new RoundedShapeFactory();         
       }else{
          return new ShapeFactory();
       }
    }
 }
