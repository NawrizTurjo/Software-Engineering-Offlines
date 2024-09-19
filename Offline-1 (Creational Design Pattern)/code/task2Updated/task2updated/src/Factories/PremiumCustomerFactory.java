package Factories;

import AbstractFactory.AbstractFactory;
import AccountConcrete.RegularAccount;
import LoanConcrete.RegularLoan;
import Operations.Account;
import Operations.Loan;

public class PremiumCustomerFactory extends AbstractFactory {

    @Override
    public Loan getLoan(int amount) {
        return new RegularLoan(amount, 0.12);
    }

    @Override
    public Account getAccount(int amount) {
        return new RegularAccount(amount, 0.035);
    }

}
