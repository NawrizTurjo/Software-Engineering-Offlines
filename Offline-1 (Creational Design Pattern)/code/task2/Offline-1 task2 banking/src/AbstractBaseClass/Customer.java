package AbstractBaseClass;

import Operations.Account;
import Operations.Loan;

public interface Customer {
    public Account getAccount();

    public void setAccount(Account account);

    public Loan getLoan();

    public void setLoan(Loan loan);
    
}