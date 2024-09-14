package Builder.ConcreteClasses;

import Builder.AbstractClasses.Burger;

public class ChickenBurger extends Burger {

    @Override
    public float price() {
       return 50.5f;
    }
 
    @Override
    public String name() {
       return "Chicken Burger";
    }
 }