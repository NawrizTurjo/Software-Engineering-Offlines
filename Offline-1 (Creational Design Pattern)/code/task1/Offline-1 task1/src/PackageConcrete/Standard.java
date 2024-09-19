package PackageConcrete;

import Interfaces.Package;

public class Standard implements Package {

    @Override
    public void addPackage() {
        System.out.println("Standard package added");
    }

}
