package InternetConnectionConcrete;

import Interfaces.InternetConnection;

public class WiFi implements InternetConnection {
    public void addInternetConnection() {
        System.out.println("WiFi added");
    }
    
    public String toString() {
        return "WiFi";
    }
}
