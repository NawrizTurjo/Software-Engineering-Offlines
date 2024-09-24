package Builder;

import ControllerConcrete.*;
import Factories.*;
import Interfaces.*;
import MicrocontrollerConcrete.*;
import Product.TicketingSystem;
import StorageConcrete.*;
import TicketingConcrete.*;

public class SystemBuilder implements SystemBuilderInterface {
    // private static SystemBuilder instance;
    TicketingSystem system = new TicketingSystem();

    // private SystemBuilder() {
    //     this.system = new TicketingSystem();
    // }

    // public static synchronized SystemBuilder getInstance() {
    //     if (instance == null) {
    //         instance = new SystemBuilder();
    //     }
    //     return instance;
    // }

    public SystemBuilder addPackage(String pkg) {
        PackageFactory packageFactory = new PackageFactory();
        SystemPackage package1 = packageFactory.getPackage(pkg);
        this.system.setPkg(package1);
        return this;
    }

    public SystemBuilder addInternetConnection(String ic) {
        InternetConnectionFactory internetConnectionFactory = new InternetConnectionFactory();
        InternetConnection internetConnection = internetConnectionFactory.getInternetConnection(ic);
        this.system.setIc(internetConnection);
        return this;
    }

    public SystemBuilder addWebServer(String web) {
        WebServerFactory webServerFactory = new WebServerFactory();
        WebServer webServer = webServerFactory.getWebServer(web);
        this.system.setWebServer(webServer);
        return this;
    }

    public void reset() {
        this.system = new TicketingSystem();
    }

    public void buildAdditionalParts(String pkg) {
        Microcontroller microcontroller = system.getPkg().getMicrocontroller();
        if (microcontroller instanceof ATMega32 || microcontroller instanceof ArduinoMega) {
            this.system.setTicketing(new RFID());
            this.system.setPayment(new Payment());
            this.system.setStorage(new SDCard());
            this.system.setController(new ThirdParty());
        } else if (microcontroller instanceof RaspberryPi) {
            this.system.setTicketing(new NFC());
            this.system.setPayment(new Payment());
            this.system.setStorage(new BuiltIn());
            this.system.setController(new Default());
        }
        // return this.system;
    }

    public TicketingSystem getSystem() {
        return this.system;
    }

}
