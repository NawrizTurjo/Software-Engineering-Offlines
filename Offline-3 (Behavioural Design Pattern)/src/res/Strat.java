

// Step 1: Define the Strategy interface
interface PaymentStrategy {
    void pay(int amount); // # ami ki korte chai
}

// Step 2: Implement Concrete Strategy classes
class CreditCardStrategy implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;

    public CreditCardStrategy(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid $" + amount + " using Credit Card.");
    }
}

class PayPalStrategy implements PaymentStrategy {
    private String email;

    public PayPalStrategy(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid $" + amount + " using PayPal.");
    }
}

class BitcoinStrategy implements PaymentStrategy {
    private String walletAddress;

    public BitcoinStrategy(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid $" + amount + " using Bitcoin.");
    }
}

// Step 3: Create the Context class
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    // Sets the current payment strategy
    // public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
    // this.paymentStrategy = paymentStrategy;
    // }

    ShoppingCart(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        if (paymentStrategy == null) {
            System.out.println("Please select a payment method.");
            return;
        }
        paymentStrategy.pay(amount);
    }
}

// Step 4: Client code
public class Strat {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart(new CreditCardStrategy("1234-5678-9012-3456", "John Doe"));

        // Choose Credit Card payment
        // cart.setPaymentStrategy());
        cart.checkout(100); // Output: Paid $100 using Credit Card.

        // Choose PayPal payment
        // cart.setPaymentStrategy(new PayPalStrategy("john@example.com"));
        cart = new ShoppingCart(new PayPalStrategy("john@example.com"));
        cart.checkout(200); // Output: Paid $200 using PayPal.

        // Choose Bitcoin payment
        // cart.setPaymentStrategy(new BitcoinStrategy("1BitcoinWalletAddress"));
        cart = new ShoppingCart(new BitcoinStrategy("1BitcoinWalletAddress"));
        cart.checkout(300); // Output: Paid $300 using Bitcoin.
    }
}

// TLDR:
// Step 1: Define the Strategy interface
// Step 2: Implement Concrete Strategy classes
// Step 3: Create the Context class
// Step 4: Client code : Client uses setMethod (not by the strategies)