package Factories;

import AbstractBaseClass.Customer;
import AbstractBaseClass.Operation;
import AbstractFactory.AbstractFactory;

public class CustomerFactory extends AbstractFactory{

    @Override
    public Operation getOperation(String operation) {
        return null;
    }

    @Override
    public Customer getCustomer(String customer) {
        if(customer.equalsIgnoreCase("REGULAR")){
            return new Customers.RegularCustomer();
        }else if(customer.equalsIgnoreCase("PREMIUM")){
            return new Customers.PremiumCustomer();
        }else if(customer.equalsIgnoreCase("VIP")){
            return new Customers.VIPCustomer();
        }
        else{
            return null;
        }
    }
    
}
