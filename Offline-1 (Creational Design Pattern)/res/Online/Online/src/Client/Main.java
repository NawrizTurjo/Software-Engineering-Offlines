package Client;

import java.util.Scanner;

import Absfact.Modelsss;
import Producer.FactoryProducer;

public class Main {
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
