package BehavioralPatterns.OtherCodes;

import java.time.LocalDateTime;

// Transaction Class
class Transaction {
    public double amount;
    public String accountID;
    public LocalDateTime timestamp;

    public Transaction(double amount, String accountID, LocalDateTime timestamp) {
        this.amount = amount;
        this.accountID = accountID;
        this.timestamp = timestamp;
    }
}

// ApprovalHandler Interface
interface ApprovalHandler {
    void handleRequest(Transaction transaction);
}

// Teller Handler
class Teller implements ApprovalHandler {
    private ApprovalHandler nextHandler;

    public Teller(ApprovalHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(Transaction transaction) {
        if (transaction.amount <= 5000) {
            System.out.println("Teller approved transaction of $" + transaction.amount);
            System.out.println("Transaction handeled at "+transaction.timestamp);
        } else {
            nextHandler.handleRequest(transaction);
        }
    }
}

// Branch Manager Handler
class BranchManager implements ApprovalHandler {
    private ApprovalHandler nextHandler;

    public BranchManager(ApprovalHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(Transaction transaction) {
        if (transaction.amount <= 20000) {
            System.out.println("Branch Manager approved transaction of $" + transaction.amount);
            System.out.println("Transaction handeled at "+transaction.timestamp);
        } else {
            nextHandler.handleRequest(transaction);
        }
    }
}

// Regional Manager Handler
class RegionalManager implements ApprovalHandler {
    private ApprovalHandler nextHandler;

    public RegionalManager(ApprovalHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(Transaction transaction) {
        if (transaction.amount <= 100000) {
            System.out.println("Regional Manager approved transaction of $" + transaction.amount);
            System.out.println("Transaction handeled at "+transaction.timestamp);
        } else {
            nextHandler.handleRequest(transaction);
        }
    }
}

// CFO Handler
class CFO implements ApprovalHandler {
    @Override
    public void handleRequest(Transaction transaction) {
        System.out.println("CFO approved transaction of $" + transaction.amount);
        System.out.println("Transaction handeled at "+transaction.timestamp);
    }
}

// Fraud Detection Handler
class FraudDetection implements ApprovalHandler {
    private ApprovalHandler nextHandler;

    public FraudDetection(ApprovalHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(Transaction transaction) {
        // Example Fraud Detection Rule: Transactions above $50,000 are flagged
        if (transaction.amount > 50000) {
            System.out.println("Fraud Detection: Warning! Large transaction of $" + transaction.amount);
        }
        // Continue to the next handler
        nextHandler.handleRequest(transaction);
    }
}

// Main Class
public class BankingCOR {
    public static ApprovalHandler getChain() {
        ApprovalHandler cfo = new CFO();
        ApprovalHandler regionalManager = new RegionalManager(cfo);
        ApprovalHandler branchManager = new BranchManager(regionalManager);
        ApprovalHandler teller = new Teller(branchManager);
        ApprovalHandler Chain = new FraudDetection(teller);
        return Chain; // Fraud Detection wraps the chain
        // Final Chain is: FraudDetection -> Teller -> BranchManager -> RegionalManager -> CFO
    }

    public static void main(String[] args) {
        ApprovalHandler chain = getChain();

        Transaction t1 = new Transaction(3000, "ACC123", LocalDateTime.now());
        Transaction t2 = new Transaction(15000, "ACC456", LocalDateTime.now());
        Transaction t3 = new Transaction(75000, "ACC789", LocalDateTime.now());
        Transaction t4 = new Transaction(150000, "ACC101", LocalDateTime.now());

        System.out.println("Processing Transactions...");
        chain.handleRequest(t1);
        chain.handleRequest(t2);
        chain.handleRequest(t3);
        chain.handleRequest(t4);
    }
}
