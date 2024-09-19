package Factories;

import AbstractFactory.AbstractFactory;
import AccountConcrete.VIPAccount;
import LoanConcrete.VIPLoan;
import Operations.Account;
import Operations.Loan;

public class VIPCustomerFactory extends AbstractFactory {
    @Override
    public Loan getLoan(int amount) {
        return new VIPLoan(amount, 0.1);
    }

    @Override
    public Account getAccount(int amount) {
        return new VIPAccount(amount, 0.05);
    }
}
