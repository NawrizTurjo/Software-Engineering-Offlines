package PackageConcrete;

import AbstractBaseClass.DisplayUnit;
import DisplayConcrete.LCDDisplay;
import Interfaces.Display;
import Interfaces.Microcontroller;
import Interfaces.SystemPackage;
import MicrocontrollerConcrete.ATMega32;

public class BasicPackage extends DisplayUnit implements SystemPackage {
    public BasicPackage() {
        super.mc = new ATMega32();
        super.display = new LCDDisplay();
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
