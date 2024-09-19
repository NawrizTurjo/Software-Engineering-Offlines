package Customers;

import AbstractBaseClass.Customer;
import Operations.Account;
import Operations.Loan;

public class RegularCustomer implements Customer {

    private Account account;
    private Loan loan;

    public RegularCustomer(){
        this.account = new Account(2.5);
        this.loan = new Loan(14);
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
        return "Regular Customer";
    }
    
}
