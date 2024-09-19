package Factories;

import AbstractFactory.AbstractFactory;
import AccountConcrete.RegularAccount;
import LoanConcrete.RegularLoan;
import Operations.Account;
import Operations.Loan;

public class VIPCustomerFactory extends AbstractFactory {
    @Override
    public Loan getLoan(int amount) {
        return new RegularLoan(amount, 0.1);
    }

    @Override
    public Account getAccount(int amount) {
        return new RegularAccount(amount, 0.05);
    }
}
