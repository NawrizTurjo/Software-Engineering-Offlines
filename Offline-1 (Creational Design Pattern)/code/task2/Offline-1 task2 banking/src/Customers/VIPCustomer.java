package Customers;

import AbstractBaseClass.Customer;
import Operations.Account;
import Operations.Loan;

public class VIPCustomer implements Customer{

    private Account account;
    private Loan loan;

    public VIPCustomer(){
        this.account = new Account(5);
        this.loan = new Loan(10);
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
        return "VIP Customer";
    }
    
}
