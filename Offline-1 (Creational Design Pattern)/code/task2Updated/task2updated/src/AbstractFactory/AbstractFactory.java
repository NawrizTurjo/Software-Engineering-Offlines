package AbstractFactory;

import AbstractBaseClass.Customer;
import AbstractBaseClass.Operation;
import Operations.Account;
import Operations.Loan;

public abstract class AbstractFactory {
    public abstract Loan getRegularCustomerLoan(int amount);

    public abstract Account getRegularCustomerAccount(int amount);

    public abstract Loan getPremiumCustomerLoan(int amount);

    public abstract Account getPremiumCustomerAccount(int amount);

    public abstract Loan getVIPCustomerLoan(int amount);

    public abstract Account getVIPCustomerAccount(int amount);
}
