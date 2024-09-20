package Director;

// import Builder.SystemBuilder;
import Builder.SystemBuilderInterface;
import Product.TicketingSystem;

public class SystemDirector {
    // private SystemBuilderInterface builder;
    // private static SystemDirector instance;

    

    // public static synchronized SystemDirector getInstance() {
    //     if (instance == null) {
    //         instance = new SystemDirector();
    //     }
    //     return instance;
    // }

    public static TicketingSystem buildSystem(SystemBuilderInterface builder, String pkg, String ic, String web) {
        // this.builder = builder;
        builder.addPackage(pkg);
        builder.addInternetConnection(ic);
        builder.addWebServer(web);
        return builder.buildAdditionalParts(pkg);
    }
    
    // public TicketingSystem construct(String pkg) {
    //     return builder.buildAdditionalParts(pkg);
    // }
}
