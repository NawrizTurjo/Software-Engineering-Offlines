package Client;

import AbstractBaseClass.Operation;
import AbstractFactory.AbstractFactory;
import Producer.FactoryProducer;

public class Client {
    public static void main(String[] args) {
        AbstractFactory regularCustomerFactory = FactoryProducer.getFactory("Regular");

        Operation regularLoan = regularCustomerFactory.getLoan(1000);
        System.out.println("Regular Loan: " + regularLoan.getTotalCompoundInterest(5));

        Operation regularAccount = regularCustomerFactory.getAccount(1000);
        System.out.println("Regular Account: " + regularAccount.getTotalCompoundInterest(5));

    }
}
