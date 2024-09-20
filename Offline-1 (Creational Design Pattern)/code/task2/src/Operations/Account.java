package Operations;

import AbstractBaseClass.Operation;

public class Account implements Operation {
    private int amount;

    public int getAmount() {
        return this.amount;
    }

    private double interestRate;

    public Account(int amount, double interestRate) {
        this.amount = amount;
        this.interestRate = interestRate / 100.0;
    }

    public Account() {
        this.amount = 0;
        this.interestRate = 0.5;
    }

    @Override
    public void deposit(int amount) {
        this.amount += amount;
    }

    @Override
    public void withdraw(int amount) {
        this.amount -= amount;
    }

    @Override
    public void setInterestRate(double rate) {
        this.interestRate = rate / 100.0;
    }

    @Override
    public double getInterestRate() {

        return this.interestRate;
    }

    @Override
    public double getTotalInterest(int year) {
        double totalInterest = this.amount * this.interestRate * year;
        return totalInterest;
    }

    @Override
    public double getTotalCompoundInterest(int year) {
        double totalInterest = this.amount * Math.pow((1 + this.interestRate), year);
        return totalInterest;
    }

    @Override
    public void setAmount(int amount) {
        this.amount = amount;
    }

}
