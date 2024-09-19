package Factories;

import Interfaces.WebServer;
import WebServerConcrete.Django;
import WebServerConcrete.NodeJS;
import WebServerConcrete.Ruby;

public class WebServerFactory {
    public WebServer getWebServer(String type) {
        if (type.equalsIgnoreCase("NodeJS")) {
            return new NodeJS();
        } else if (type.equalsIgnoreCase("Django")) {
            return new Django();
        } 
        else if (type.equalsIgnoreCase("Ruby")) {
            return new Ruby();
        }
        else {
            return null;
        }
    }
}
