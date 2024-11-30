package OtherOnlines;

interface PaymentMethod {
    void pay(int amount);
}

class CreditCardPayment implements PaymentMethod {

    @Override
    public void pay(int amount) {
        System.out.println("Paid $" + amount + " using Credit Card.");
    }

}

class BKash implements PaymentMethod {

    @Override
    public void pay(int amount) {
        System.out.println("Paid $" + amount + " using Bkash.");
    }

}

class Crypto implements PaymentMethod {

    @Override
    public void pay(int amount) {
        System.out.println("Paid $" + amount + " using Crypto.");
    }

}

class PaymentContext {
    private PaymentMethod paymentMethod;

    PaymentContext(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void checkout(int amount) {
        if (paymentMethod == null) {
            System.out.println("Please select a payment method.");
            return;
        }
        paymentMethod.pay(amount);
    }
}

public class A1Online {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext(new CreditCardPayment());
        paymentContext.checkout(100);

        paymentContext = new PaymentContext(new BKash());
        paymentContext.checkout(200);

        paymentContext = new PaymentContext(new Crypto());
        paymentContext.checkout(300);
    }
}
