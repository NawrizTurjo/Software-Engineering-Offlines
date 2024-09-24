package Client;

import Director.SystemDirector;
import Product.TicketingSystem;

import java.util.*;

import Builder.SystemBuilder;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SystemBuilder builder = new SystemBuilder();
        System.out.println("-----------------------------Client Class-----------------------------");
        System.out.println("The Features of the System are:");
        System.out.println("1. Package");
        System.out.println("\tWe provide 4 different packages of services:");
        System.out.println("\t\t1. Basic Package: Contains ATMega32 with LCD display");
        System.out.println("\t\t2. Standard Package: Contains Arduino Mega with LED display");
        System.out.println("\t\t3. Advanced Package: Contains Raspberry Pi with OLED display");
        System.out.println("\t\t4. Premium Package: Contains Raspberry Pi with touch screen display");
        System.out.println("2. Internet Connection: WiFi,GSM,Ethernet");
        System.out.println("3. Web Server: NodeJS,Django,Ruby");
        System.out.println("------------------------------------------------------------------------");

        System.out.print("Enter the package name: ");
        String packageName = sc.nextLine();
        System.out.println("Creating a " + packageName + " Package");
        System.out.print("Enter the type of internet connection: ");
        String internetConnection = sc.nextLine();
        System.out.print("Enter the type of web server: ");
        String webServer = sc.nextLine();

        // SystemDirector director = SystemDirector.buildSystem(builder, packageName,
        // internetConnection, webServer);
        // TicketingSystem ts = director.construct(packageName);
        SystemDirector.buildSystem(builder, packageName, internetConnection, webServer);
        TicketingSystem ts = builder.getSystem();
        ts.display();

        System.out.println("------------------------------------------------------------------------");
        System.out.print("Enter the package name: ");
        packageName = sc.nextLine();
        System.out.println("Creating a " + packageName + " Package");
        System.out.print("Enter the type of internet connection: ");
        internetConnection = sc.nextLine();
        System.out.print("Enter the type of web server: ");
        webServer = sc.nextLine();

        builder.reset();
        // director = new SystemDirector(builder, packageName, internetConnection,
        // webServer);
        SystemDirector.buildSystem(builder, packageName, internetConnection, webServer);

        ts = builder.getSystem();
        ts.display();

        System.out.println("------------------------------------------------------------------------");
        System.out.print("Enter the package name: ");
        packageName = sc.nextLine();
        System.out.println("Creating a " + packageName + " Package");
        System.out.print("Enter the type of internet connection: ");
        internetConnection = sc.nextLine();
        System.out.print("Enter the type of web server: ");
        webServer = sc.nextLine();

        builder.reset();
        // director = new SystemDirector(builder, packageName, internetConnection,
        // webServer);
        SystemDirector.buildSystem(builder, packageName, internetConnection, webServer);

        ts = builder.getSystem();
        ts.display();

        System.out.println("------------------------------------------------------------------------");
        System.out.print("Enter the package name: ");
        packageName = sc.nextLine();
        System.out.println("Creating a " + packageName + " Package");
        System.out.print("Enter the type of internet connection: ");
        internetConnection = sc.nextLine();
        System.out.print("Enter the type of web server: ");
        webServer = sc.nextLine();

        builder.reset();
        // director = new SystemDirector(builder, packageName, internetConnection,
        // webServer);
        SystemDirector.buildSystem(builder, packageName, internetConnection, webServer);

        ts = builder.getSystem();
        ts.display();

        sc.close();
    }
}
