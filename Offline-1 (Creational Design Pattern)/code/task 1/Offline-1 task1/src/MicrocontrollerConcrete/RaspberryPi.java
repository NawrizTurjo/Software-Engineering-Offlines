package MicrocontrollerConcrete;

import Interfaces.Microcontroller;

public class RaspberryPi implements Microcontroller{
    @Override
    public void addMicrocontroller() {
        System.out.println("Rasberry Pi has been added to the system.");
    }
    public String toString() {
        return "Rasberry Pi";
    }
}
