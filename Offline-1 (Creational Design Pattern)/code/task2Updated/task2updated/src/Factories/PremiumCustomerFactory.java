package Factories;

import AbstractFactory.AbstractFactory;
import Operations.Account;
import Operations.Loan;

public class PremiumCustomerFactory extends AbstractFactory {
    @Override
    public Loan getPremiumCustomerLoan(int amount) {
        return new Loan(amount, 0.12);
    }

    @Override
    public Account getVIPCustomerAccount(int amount) {
        // Implement the method
        return null;
    }

    @Override
    public Loan getRegularCustomerLoan(int amount) {
        // Implement the method
        return null;
    }

    @Override
    public Account getRegularCustomerAccount(int amount) {
        return null;
    }

    @Override
    public Loan getVIPCustomerLoan(int amount) {
        // Implement the method
        return null;
    }

    @Override
    public Account getPremiumCustomerAccount(int amount) {
        // Implement the method
        return new Account(amount, 0.035);
    }
}
