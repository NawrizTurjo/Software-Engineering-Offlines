package Producer;

import AbstractFactory.AbstractFactory;
import Factories.CustomerFactory;
import Factories.OperationsFactory;

public class FactoryProducer {
    public static AbstractFactory getFactory(String factory) {
        if (factory.equalsIgnoreCase("Operation")) {
            return new OperationsFactory();
        } else if (factory.equalsIgnoreCase("Customer")) {
            return new CustomerFactory();
        }
        return null;
    }
}
