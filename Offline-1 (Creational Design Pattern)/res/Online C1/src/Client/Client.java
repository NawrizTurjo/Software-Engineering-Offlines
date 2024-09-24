package Client;

import java.util.Scanner;

import Factory.PayMethodFactory;
import PaymentInterface.PayMethods;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the payment method you want to use: ");
        String payMethod = sc.nextLine();
        PayMethods payMethodFactory = PayMethodFactory.getPayMethod(payMethod);
        payMethodFactory.pay();
        sc.close();
    }
}
