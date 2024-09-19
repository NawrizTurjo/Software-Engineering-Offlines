package DisplayConcrete;

import Interfaces.Display;

public class LEDDisplay implements Display{

    @Override
    public void addDisplay() {
        System.out.println("LED Display has been added to the system.");
    }
    
}
