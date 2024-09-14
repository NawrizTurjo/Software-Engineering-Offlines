package Builder.CommonConcrete;

import Builder.Interfaces.Packing;

public class Wrapper implements Packing {

    @Override
    public String pack() {
       return "Wrapper";
    }
 }
