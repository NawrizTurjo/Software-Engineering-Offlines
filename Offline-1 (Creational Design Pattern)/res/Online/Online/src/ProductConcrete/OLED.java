package ProductConcrete;

import ProductInterface.Displays;

public class OLED implements Displays {

    @Override
    public void printDisplay() {
        System.out.println("OLED Display");
    }

}
