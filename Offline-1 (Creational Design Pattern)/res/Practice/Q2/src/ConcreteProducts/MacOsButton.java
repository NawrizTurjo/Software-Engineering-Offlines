package ConcreteProducts;

import Interfaces.Button;

public class MacOsButton implements Button {
    @Override
    public void printButtonType() {
        System.out.println("MacOs Button");
    }
    
}
