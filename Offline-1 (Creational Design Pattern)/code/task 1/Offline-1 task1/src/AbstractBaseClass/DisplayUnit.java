package AbstractBaseClass;

import Interfaces.Display;
import Interfaces.Microcontroller;

public abstract class DisplayUnit {
    protected Microcontroller mc;
    protected Display display;
    public String toString()
    {
        return this.getClass().getSimpleName()+" with "+this.mc.toString()+" and "+this.display.toString();
    }
}
