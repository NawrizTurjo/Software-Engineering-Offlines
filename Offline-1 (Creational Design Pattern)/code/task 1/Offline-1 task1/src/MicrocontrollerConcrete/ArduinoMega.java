package MicrocontrollerConcrete;

import Interfaces.Microcontroller;

public class ArduinoMega implements Microcontroller{
    @Override
    public void addMicrocontroller() {
        System.out.println("Arduino Mega has been added to the system.");
    }
    public String toString() {
        return "Arduino Mega";
    }
}
