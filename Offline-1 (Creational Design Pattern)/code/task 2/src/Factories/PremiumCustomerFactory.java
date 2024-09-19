package Factories;

import AbstractFactory.AbstractFactory;
import AccountConcrete.PremiumAccount;
import LoanConcrete.PremiumLoan;
import Operations.Account;
import Operations.Loan;

public class PremiumCustomerFactory extends AbstractFactory {

    @Override
    public Loan getLoan(int amount) {
        return new PremiumLoan(amount, 0.12);
    }

    @Override
    public Account getAccount(int amount) {
        return new PremiumAccount(amount, 0.035);
    }

}