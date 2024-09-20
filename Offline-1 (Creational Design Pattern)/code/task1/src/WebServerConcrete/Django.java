package WebServerConcrete;

import Interfaces.WebServer;

public class Django implements WebServer {
    public void addWebServer() {
        System.out.println("Django added to the project.");
    }
    
    public String toString() {
        return "Django Web Server";
    }
}
