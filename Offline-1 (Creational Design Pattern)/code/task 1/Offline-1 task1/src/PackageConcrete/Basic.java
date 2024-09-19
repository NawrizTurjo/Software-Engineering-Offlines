package PackageConcrete;

import Interfaces.Package;

public class Basic implements Package {

    @Override
    public void addPackage() {
        System.out.println("Basic package added");
    }
    
}
