package AbstractFactory;

import AbstractBaseClass.Customer;
import AbstractBaseClass.Operation;

public abstract class AbstractFactory {
    public abstract Operation getOperation(String operation);
    public abstract Customer getCustomer(String customer);
}
