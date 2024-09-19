package ControllerConcrete;

import Interfaces.Controller;

public class ThirdParty implements Controller {
    public void addController() {
        System.out.println("ThirdParty Controller added");
    }
    public String toString() {
        return "ThirdParty Controller";
    }
}
