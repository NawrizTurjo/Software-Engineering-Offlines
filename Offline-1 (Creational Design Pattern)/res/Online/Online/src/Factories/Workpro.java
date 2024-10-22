package Factories;

import Absfact.Modelsss;
import ProductConcrete.*;
import ProductInterface.*;

public class Workpro extends Modelsss {
    Processors processor;
    Displays display;

    public Workpro() {
        processor = new Intel();
        display = new IPS();
        System.out.println("Building Workpro Model..");
    }

    @Override
    public void printModel() {
        processor.printProcessor();
    }

    @Override
    public void printDisplay() {
        display.printDisplay();
    }

}
