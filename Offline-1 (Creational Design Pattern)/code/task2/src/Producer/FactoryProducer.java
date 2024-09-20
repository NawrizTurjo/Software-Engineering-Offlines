package Producer;

import AbstractFactory.AbstractFactory;
import Factories.PremiumCustomerFactory;
import Factories.RegularCustomerFactory;
import Factories.VIPCustomerFactory;

public class FactoryProducer {
    public static AbstractFactory getFactory(String factory) {
        if (factory.equalsIgnoreCase("Regular")) {
            return new RegularCustomerFactory();
        } else if (factory.equalsIgnoreCase("Premium")) {
            return new PremiumCustomerFactory();
        } else if (factory.equalsIgnoreCase("VIP")) {
            return new VIPCustomerFactory();
        }
        return null;
    }
}
