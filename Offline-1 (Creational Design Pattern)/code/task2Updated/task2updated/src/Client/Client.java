package Client;

import AbstractBaseClass.Customer;
import AbstractBaseClass.Operation;
import AbstractFactory.AbstractFactory;
import Operations.Account;
import Operations.Loan;
import Producer.FactoryProducer;

public class Client {
    public static void main(String[] args) {
        AbstractFactory regularCustomerFactory = FactoryProducer.getFactory("Regular");
        Operation regularLoan = regularCustomerFactory.getRegularCustomerLoan(1000);
        System.out.println("Regular Loan: " + regularLoan.getTotalCompoundInterest(5));

        Operation regularAccount = regularCustomerFactory.getRegularCustomerAccount(1000);
        System.out.println("Regular Account: " + regularAccount.getTotalCompoundInterest(5));

    }
}
