package Client;

import java.util.Scanner;

import ConcreteFactory.*;
import Factory.GUIFactory;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the type of GUI you want to create (Windows/MacOs): ");
        String guiType = sc.nextLine();

        GUIFactory factory;
        if(guiType.equalsIgnoreCase("WINDOWS"))
        {
            factory = new WindowsFactory();
        }
        else if(guiType.equalsIgnoreCase("MACOS"))
        {
            factory = new MacOsFactory();
        }
        else
        {
            System.out.println("Invalid input. Exiting...");
            sc.close();
            return;
        }

        Application app = new Application(factory);
        app.render();

        sc.close();
    }
}
