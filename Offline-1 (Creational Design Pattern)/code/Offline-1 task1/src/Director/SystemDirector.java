package Director;

import Builder.SystemBuilder;
import Builder.SystemBuilderInterface;
import Product.TicketingSystem;

public class SystemDirector {
    private SystemBuilderInterface builder;

    public SystemDirector(SystemBuilder builder,String pkg,String ic, String web)
    {
        this.builder = builder;
        builder.addPackage(pkg);
        builder.addInternetConnection(ic);
        builder.addWebServer(web);
    }

    public TicketingSystem construct(String pkg)
    {
        return builder.buildAdditionalParts(pkg);
    }
}
