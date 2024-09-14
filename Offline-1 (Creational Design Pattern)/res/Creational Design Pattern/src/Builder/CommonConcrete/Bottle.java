package Builder.CommonConcrete;

import Builder.Interfaces.Packing;

public class Bottle implements Packing {

    @Override
    public String pack() {
       return "Bottle";
    }
 }
