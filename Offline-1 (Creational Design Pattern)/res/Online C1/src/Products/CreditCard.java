package Products;

import PaymentInterface.PayMethods;

public class CreditCard implements PayMethods {
    public void pay() {
        System.out.println("Payment made with Credit Card");
    }
    
}
