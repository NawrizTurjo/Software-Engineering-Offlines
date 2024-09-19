package DisplayConcrete;

import Interfaces.Display;

public class TouchDisplay implements Display{

    @Override
    public void addDisplay() {
        System.out.println("Touch Display has been added to the system.");
    }
    
}
