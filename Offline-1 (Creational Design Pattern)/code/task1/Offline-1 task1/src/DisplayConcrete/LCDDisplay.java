package DisplayConcrete;

import Interfaces.Display;

public class LCDDisplay implements Display {

    @Override
    public void addDisplay() {
        System.out.println("LCD Display has been added to the system.");
    }

}
