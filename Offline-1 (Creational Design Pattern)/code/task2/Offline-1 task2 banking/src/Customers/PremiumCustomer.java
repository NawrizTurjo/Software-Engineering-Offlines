package Customers;

import AbstractBaseClass.Customer;
import Operations.Account;
import Operations.Loan;

public class PremiumCustomer implements Customer{
    private Account account;
    private Loan loan;

    public PremiumCustomer(){
        this.account = new Account(3.5);
        this.loan = new Loan(12);
    }

    @Override
    public Account getAccount() {
        return this.account;
    }

    @Override
    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public Loan getLoan() {
        return this.loan;
    }

    @Override
    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public String toString(){
        return "Premium Customer";
    }
    
}
