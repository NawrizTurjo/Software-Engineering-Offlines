package PackageConcrete;

import AbstractBaseClass.DisplayUnit;
import DisplayConcrete.LEDDisplay;
import Interfaces.Display;
import Interfaces.Microcontroller;
import Interfaces.SystemPackage;
import MicrocontrollerConcrete.ArduinoMega;

public class StandardPackage extends DisplayUnit implements SystemPackage {

    public StandardPackage() {
        super.mc = new ArduinoMega();
        super.display = new LEDDisplay();
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
