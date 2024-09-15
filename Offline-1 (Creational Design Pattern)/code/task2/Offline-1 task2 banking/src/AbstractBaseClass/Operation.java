package AbstractBaseClass;

public interface Operation {
    // int amount = 0;

    public int getAmount();

    public void deposit(int amount);

    public void withdraw(int amount);

    public void setAmount(int amount);

    // double interestRate = 0.5;

    public void setInterestRate(double rate);

    public double getInterestRate();

    public double getTotalInterest(int year);

    public double getTotalCompoundInterest(int year);

}