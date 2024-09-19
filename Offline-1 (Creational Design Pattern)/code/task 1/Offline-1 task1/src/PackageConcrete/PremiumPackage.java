package PackageConcrete;

import AbstractBaseClass.DisplayUnit;
import DisplayConcrete.TouchDisplay;
import Interfaces.Display;
import Interfaces.Microcontroller;
import Interfaces.SystemPackage;
import MicrocontrollerConcrete.RaspberryPi;

public class PremiumPackage extends DisplayUnit implements SystemPackage {

    public PremiumPackage()
    {
        super.mc = new RaspberryPi();
        super.display = new TouchDisplay();
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
