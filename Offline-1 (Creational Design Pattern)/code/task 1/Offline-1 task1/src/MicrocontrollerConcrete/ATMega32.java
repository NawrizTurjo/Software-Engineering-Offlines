package MicrocontrollerConcrete;

import Interfaces.Microcontroller;

public class ATMega32 implements Microcontroller{
    @Override
    public void addMicrocontroller() {
        System.out.println("ATMega32 has been added to the system.");
    }
    public String toString() {
        return "ATMega32";
    }
}
