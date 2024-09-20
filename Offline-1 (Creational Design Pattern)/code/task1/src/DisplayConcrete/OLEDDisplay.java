package DisplayConcrete;

import Interfaces.Display;

public class OLEDDisplay implements Display{

    @Override
    public void addDisplay() {
        System.out.println("OLED Display has been added to the system.");
    }
    
    public String toString() {
        return "OLED Display";
    }
}
