package VehicleClient;

import java.util.Scanner;

import Interfaces.Vehicle;
import Producer.RideSelect;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the vehicle type: ");
        String userInput = sc.nextLine();
        Vehicle vehicle = RideSelect.getVehicle(userInput);
        vehicle.booking();
        sc.close();
    }
}
