package Client;

import AbstractBaseClass.Customer;
import AbstractBaseClass.Operation;
import AbstractFactory.AbstractFactory;
import Operations.Account;
import Producer.FactoryProducer;

public class Client {
    public static void main(String[] args) {
        AbstractFactory customerFactory = FactoryProducer.getFactory("customer");
        Customer regularCustomer = customerFactory.getCustomer("regular");
        System.out.println(regularCustomer);
        
        AbstractFactory operationFactory = FactoryProducer.getFactory("operation");
        // Operation account = operationFactory.getOperation("account");
        // Account  = (Account) operation;

        
        // regularCustomer.setAccount((Account)account);
        regularCustomer.getLoan().setAmount(15000);
        System.out.println(regularCustomer.getLoan().getTotalCompoundInterest(10));

        regularCustomer.getAccount().setAmount(10000);
        System.out.println(regularCustomer.getAccount().getTotalInterest(5));

    }
}
