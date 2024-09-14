package Builder.AbstractClasses;

import Builder.CommonConcrete.Wrapper;
import Builder.Interfaces.Item;
import Builder.Interfaces.Packing;

public abstract class Burger implements Item {

    @Override
    public Packing packing() {
       return new Wrapper();
    }
 
    @Override
    public abstract float price();
 }