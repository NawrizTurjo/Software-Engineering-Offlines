package WebServerConcrete;

import Interfaces.WebServer;

public class NodeJS implements WebServer {
    public void addWebServer() {
        System.out.println("NodeJS added to the project.");
    }
    
    public String toString() {
        return "NodeJS Web Server";
    }
}
