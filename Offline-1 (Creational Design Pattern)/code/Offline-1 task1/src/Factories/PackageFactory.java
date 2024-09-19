package Factories;

import Interfaces.SystemPackage;
import PackageConcrete.AdvancedPackage;
import PackageConcrete.BasicPackage;
import PackageConcrete.PremiumPackage;
import PackageConcrete.StandardPackage;

public class PackageFactory {
    public SystemPackage getPackage(String type) {
        if (type.equalsIgnoreCase("Basic")) {
            return new BasicPackage();
        } else if (type.equalsIgnoreCase("Advanced")) {
            return new AdvancedPackage();
        }else if(type.equalsIgnoreCase("Premium"))
        {
            return new PremiumPackage();
        }
        else if(type.equalsIgnoreCase("Standard"))
        {
            return new StandardPackage();
        }
         else {
            return null;
        }
    }
}
