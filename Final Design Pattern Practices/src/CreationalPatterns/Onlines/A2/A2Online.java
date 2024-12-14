package CreationalPatterns.Onlines.A2;

import java.util.Scanner;

interface Displays {
    public void printDisplay();
}

class OLED implements Displays {

    @Override
    public void printDisplay() {
        System.out.println("OLED Display");
    }

}

class IPS implements Displays {

    @Override
    public void printDisplay() {
        System.out.println("IPS Display");
    }

}

interface Processors {
    public void printProcessor();
}

class Intel implements Processors {

    @Override
    public void printProcessor() {
        System.out.println("Intel Xeon Processor");
    }

}

class ARM implements Processors {

    @Override
    public void printProcessor() {
        System.out.println("ARM Processor");
    }

}

abstract class Modelsss {
    public abstract void printModel();

    public abstract void printDisplay();
}

class LiteMax extends Modelsss {
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

class Workpro extends Modelsss {
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

class FactoryProducer {
    public static Modelsss getModel(String model) {
        if (model.equalsIgnoreCase("WORKPRO")) {
            return new Workpro();
        } else if (model.equalsIgnoreCase("LITEMAX")) {
            return new LiteMax();
        } else {
            return null;
        }
    }
}

public class A2Online {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a Model: 1.Workpro, 2.Litemax");

        String modelName = sc.nextLine();

        Modelsss model = FactoryProducer.getModel(modelName);
        model.printDisplay();
        model.printModel();

        sc.close();
    }
}
