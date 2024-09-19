package Builder;

import ControllerConcrete.Default;
import ControllerConcrete.ThirdParty;
import DisplayConcrete.TouchDisplay;
import Factories.InternetConnectionFactory;
import Factories.PackageFactory;
import Factories.WebServerFactory;
import Interfaces.InternetConnection;
import Interfaces.Microcontroller;
import Interfaces.Payment;
import Interfaces.SystemPackage;
import Interfaces.WebServer;
import MicrocontrollerConcrete.ATMega32;
import MicrocontrollerConcrete.ArduinoMega;
import MicrocontrollerConcrete.RaspberryPi;
import Product.TicketingSystem;
import StorageConcrete.BuiltIn;
import StorageConcrete.SDCard;
import TicketingConcrete.NFC;
import TicketingConcrete.RFID;

public class SystemBuilder implements SystemBuilderInterface{
    TicketingSystem system = new TicketingSystem();

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

    public TicketingSystem buildAdditionalParts(String pkg) {
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
        return this.system;
    }

}
