package Onlines.Practice;

// Legacy PayPal Gateway, which we cannot modify
class PayPalGateway {
    public void processPayPalPayment(double amount) {
        System.out.println("Processing PayPal payment of " + amount);
    }
}

// Client Interface expected by the application
interface PaymentGateway {
    void processPayment(double amount);
}

// Application class that depends on the PaymentGateway interface
class ECommercePlatform {
    private PaymentGateway paymentGateway;

    public ECommercePlatform(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void completePayment(double amount) {
        paymentGateway.processPayment(amount);
    }
}

class PayPalAdapter implements PaymentGateway {
    private PayPalGateway palGateway;

    public PayPalAdapter(PayPalGateway palGateway) {
        this.palGateway = palGateway;
    }

    @Override
    public void processPayment(double amount) {
        palGateway.processPayPalPayment(amount);
    }

}

// Main Class
public class PayyPal {
    public static void main(String[] args) {
        // Legacy service instance
        PayPalGateway payPalGateway = new PayPalGateway();

        // Adapter to make PayPalGateway compatible with PaymentGateway interface
        PaymentGateway paymentGateway = new PayPalAdapter(payPalGateway);

        ECommercePlatform platform = new ECommercePlatform(paymentGateway);
        platform.completePayment(200.0); // Output: Processing PayPal payment of 200.0
    }
}
