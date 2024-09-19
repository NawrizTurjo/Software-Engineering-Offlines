package InternetConnectionConcrete;

import Interfaces.InternetConnection;

public class Ethernet implements InternetConnection {
    public void addInternetConnection() {
        System.out.println("Ethernet added");
    }
    public String toString() {
        return "Ethernet";
    }

}
