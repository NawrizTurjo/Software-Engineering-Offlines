package Factories;

import AbstractFactory.AbstractFactory;
import AccountConcrete.RegularAccount;
import LoanConcrete.RegularLoan;
import Operations.Account;
import Operations.Loan;

public class RegularCustomerFactory extends AbstractFactory {

    @Override
    public Loan getLoan(int amount) {
        return new RegularLoan(amount, 0.14);
    }

    @Override
    public Account getAccount(int amount) {
        return new RegularAccount(amount, 0.025);
    }
}
