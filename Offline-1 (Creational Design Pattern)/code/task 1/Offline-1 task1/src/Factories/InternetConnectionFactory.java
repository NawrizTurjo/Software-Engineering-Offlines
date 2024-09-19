package Factories;

import Interfaces.InternetConnection;
import InternetConnectionConcrete.Ethernet;
import InternetConnectionConcrete.GSM;
import InternetConnectionConcrete.WiFi;

public class InternetConnectionFactory {
    public InternetConnection getInternetConnection(String type) {
        if (type.equalsIgnoreCase("Ethernet")) {
            return new Ethernet();
        } else if (type.equalsIgnoreCase("WiFi")) {
            return new WiFi();
        } else if (type.equalsIgnoreCase("GSM")) {
            return new GSM();
        } else {
            return null;
        }
    }
}
