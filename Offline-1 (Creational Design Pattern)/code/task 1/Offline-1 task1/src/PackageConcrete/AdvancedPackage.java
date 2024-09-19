package PackageConcrete;

import AbstractBaseClass.DisplayUnit;
import DisplayConcrete.OLEDDisplay;
import Interfaces.Display;
import Interfaces.Microcontroller;
import Interfaces.SystemPackage;
import MicrocontrollerConcrete.RaspberryPi;

public class AdvancedPackage extends DisplayUnit implements SystemPackage {
    public AdvancedPackage()
    {
        super.mc = new RaspberryPi();
        super.display = new OLEDDisplay();
    }

    @Override
    public void addPackage() {
        System.out.println("Basic package added");
    }

    @Override
    public Microcontroller getMicrocontroller() {
        return super.mc;
    }

    @Override
    public Display getDisplay() {
        return super.display;
    }

    @Override
    public DisplayUnit getDisplayUnit() {
        return this;
    }
    
    
}
