package ProductConcrete;

import ProductInterface.Displays;

public class IPS implements Displays {

    @Override
    public void printDisplay() {
        System.out.println("IPS Display");
    }
    
}
