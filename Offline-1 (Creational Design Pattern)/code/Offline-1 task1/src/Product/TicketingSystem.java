package Product;

import Interfaces.Controller;
import Interfaces.InternetConnection;
import Interfaces.Payment;
import Interfaces.Storage;
import Interfaces.SystemPackage;
import Interfaces.Ticketing;
import Interfaces.WebServer;

public class TicketingSystem {
    InternetConnection ic;
    SystemPackage pkg;
    Ticketing ticketing;
    Payment payment;
    Storage storage;
    Controller controller;
    WebServer webServer;

    public void setIc(InternetConnection ic) {
        this.ic = ic;
    }
    public void setPkg(SystemPackage pkg) {
        this.pkg = pkg;
    }
    public void setTicketing(Ticketing ticketing) {
        this.ticketing = ticketing;
    }
    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    public void setStorage(Storage storage) {
        this.storage = storage;
    }
    public void setController(Controller controller) {
        this.controller = controller;
    }
    public void setWebServer(WebServer webServer) {
        this.webServer = webServer;
    }

    public SystemPackage getPkg() {
        return this.pkg;
    }

    public void display() {
        System.out.println("-------------------------Ticketing System-------------------------");
        System.out.println("Internet Connection: " + ic);
        System.out.println("Package: " + pkg);
        System.out.println("Identification: " + ticketing);
        System.out.println("Payment: " + payment);
        System.out.println("Storage: " + storage);
        System.out.println("Controller: " + controller);
        System.out.println("Web Server: " + webServer);
    }
    
}
