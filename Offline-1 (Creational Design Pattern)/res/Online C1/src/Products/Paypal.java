package Products;

import PaymentInterface.PayMethods;

public class Paypal implements PayMethods {
    public void pay() {
        System.out.println("Payment made with Paypal");
    }
    
}
