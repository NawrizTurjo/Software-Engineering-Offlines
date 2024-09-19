package Builder;

import Product.TicketingSystem;

public interface SystemBuilderInterface {
    SystemBuilderInterface addPackage(String pkg);
    SystemBuilderInterface addInternetConnection(String ic);
    SystemBuilderInterface addWebServer(String web);
    TicketingSystem buildAdditionalParts(String pkg);
}
