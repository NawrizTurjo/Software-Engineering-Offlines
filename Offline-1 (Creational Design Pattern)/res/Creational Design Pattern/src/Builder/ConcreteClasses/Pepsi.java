package Builder.ConcreteClasses;

import Builder.AbstractClasses.ColdDrink;

public class Pepsi extends ColdDrink {

    @Override
    public float price() {
       return 35.0f;
    }
 
    @Override
    public String name() {
       return "Pepsi";
    }
 }