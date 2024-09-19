package ControllerConcrete;

import Interfaces.Controller;

public class Default implements Controller {
    public void addController() {
        System.out.println("Default Controller added");
    }
    public String toString() {
        return "Default Controller";
    }
}
