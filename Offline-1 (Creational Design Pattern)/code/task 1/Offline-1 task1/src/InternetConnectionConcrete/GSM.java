package InternetConnectionConcrete;

import Interfaces.InternetConnection;

public class GSM implements InternetConnection {
    public void addInternetConnection() {
        System.out.println("GSM added");
    }
    public String toString() {
        return "GSM";
    }
    
}
