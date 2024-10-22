package ProductConcrete;

import ProductInterface.Processors;

public class ARM implements Processors{

    @Override
    public void printProcessor() {
        System.out.println("ARM Processor");
    }
    
}
