package Factory;

import PaymentInterface.PayMethods;
import Products.*;

public class PayMethodFactory {
    public static PayMethods getPayMethod(String payMethod) {
        if (payMethod == null) {
            return null;
        }
        if (payMethod.equalsIgnoreCase("CREDITCARD")) {
            return new CreditCard();
        } else if (payMethod.equalsIgnoreCase("PAYPAL")) {
            return new Paypal();
        } else if (payMethod.equalsIgnoreCase("CRYPTO")) {
            return new Crypto();
        }
        return null;
    }
    
}
