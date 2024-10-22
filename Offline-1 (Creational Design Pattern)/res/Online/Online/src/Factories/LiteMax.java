package Factories;

import Absfact.Modelsss;
import ProductConcrete.*;
import ProductInterface.*;

public class LiteMax extends Modelsss {
    Processors processor;
    Displays display;

    public LiteMax() {
        processor = new ARM();
        display = new OLED();
        System.out.println("Building Litemax Model..");
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
