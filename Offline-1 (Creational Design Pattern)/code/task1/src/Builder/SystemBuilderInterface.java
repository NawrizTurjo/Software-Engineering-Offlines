package Builder;

import Product.TicketingSystem;

public interface SystemBuilderInterface {
    SystemBuilderInterface addPackage(String pkg);
    SystemBuilderInterface addInternetConnection(String ic);
    SystemBuilderInterface addWebServer(String web);
    void buildAdditionalParts(String pkg);
    TicketingSystem getSystem();
}
