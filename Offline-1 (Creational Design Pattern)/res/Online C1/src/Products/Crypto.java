package Products;

import PaymentInterface.PayMethods;

public class Crypto implements PayMethods {
    public void pay() {
        System.out.println("Payment made with Crypto");
    }

}
