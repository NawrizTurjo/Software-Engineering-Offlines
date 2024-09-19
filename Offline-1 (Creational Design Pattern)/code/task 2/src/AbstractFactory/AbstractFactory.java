package AbstractFactory;

import Operations.Account;
import Operations.Loan;

public abstract class AbstractFactory {
    public abstract Loan getLoan(int amount);

    public abstract Account getAccount(int amount);
}
