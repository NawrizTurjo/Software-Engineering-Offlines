package PackageConcrete;

import Interfaces.Package;

public class Premium implements Package {

    @Override
    public void addPackage() {
        System.out.println("Premium package added");
    }
    
}
