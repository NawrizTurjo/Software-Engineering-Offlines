package Onlines.Practice;

// Subsystem Classes
class Account {
    private int accountNumber;
    private double balance;

    public Account(int accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public boolean hasSufficientBalance(double amount) {
        return balance >= amount;
    }

    public void debit(double amount) {
        balance -= amount;
        System.out.println("Debited: $" + amount);
    }

    public void credit(double amount) {
        balance += amount;
        System.out.println("Credited: $" + amount);
    }

    public double getBalance() {
        return balance;
    }
}

class AccountVerification {
    private int accountNumber;
    private int securityCode;

    public AccountVerification(int accountNumber, int securityCode) {
        this.accountNumber = accountNumber;
        this.securityCode = securityCode;
    }

    public boolean verify(int inputAccountNumber, int inputSecurityCode) {
        return inputAccountNumber == accountNumber && inputSecurityCode == securityCode;
    }
}

class LoanService {
    public boolean checkLoanEligibility(double balance) {
        // Simple eligibility check based on balance
        return balance > 5000;
    }

    public void approveLoan(double amount) {
        System.out.println("Loan approved for $" + amount);
    }
}

class NotificationSystem {
    public void sendNotification(String message) {
        System.out.println("Notification: " + message);
    }
}

// Facade Class
class BankFacade {
    private Account account;
    private AccountVerification accountVerification;
    private LoanService loanService;
    private NotificationSystem notificationSystem;

    public BankFacade(int accountNumber, double initialBalance, int securityCode) {
        this.account = new Account(accountNumber, initialBalance);
        this.accountVerification = new AccountVerification(accountNumber, securityCode);
        this.loanService = new LoanService();
        this.notificationSystem = new NotificationSystem();
    }

    public void withdraw(int accountNumber, int securityCode, double amount) {
        if (accountVerification.verify(accountNumber, securityCode) && account.hasSufficientBalance(amount)) {
            account.debit(amount);
            notificationSystem.sendNotification("Withdrawal of $" + amount + " successful.");
        } else {
            notificationSystem.sendNotification("Withdrawal failed: Verification or balance issue.");
        }
    }

    public void deposit(int accountNumber, int securityCode, double amount) {
        if (accountVerification.verify(accountNumber, securityCode)) {
            account.credit(amount);
            notificationSystem.sendNotification("Deposit of $" + amount + " successful.");
        } else {
            notificationSystem.sendNotification("Deposit failed: Verification issue.");
        }
    }

    public void applyForLoan(int accountNumber, int securityCode, double loanAmount) {
        if (accountVerification.verify(accountNumber, securityCode)
                && loanService.checkLoanEligibility(account.getBalance())) {
            loanService.approveLoan(loanAmount);
            notificationSystem.sendNotification("Loan application approved for $" + loanAmount);
        } else {
            notificationSystem.sendNotification("Loan application denied: Verification or eligibility issue.");
        }
    }
}

// Usage Example
public class BankSystemTest {
    public static void main(String[] args) {
        BankFacade bankFacade = new BankFacade(123456, 10000, 1234);

        bankFacade.deposit(123456, 1234, 500); // Deposit $500
        bankFacade.withdraw(123456, 1234, 1500); // Withdraw $1500
        bankFacade.applyForLoan(123456, 1234, 3000); // Apply for a $3000 loan
    }
}