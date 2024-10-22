package ConcreteProducts;

import Interfaces.Button;

public class WindowsButton implements Button {
    @Override
    public void printButtonType() {
        System.out.println("Windows Button");
    }

}
