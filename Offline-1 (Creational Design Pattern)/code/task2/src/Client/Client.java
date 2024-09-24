package Client;

import java.util.Scanner;

import AbstractBaseClass.Operation;
import AbstractFactory.AbstractFactory;
import Producer.FactoryProducer;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer type: ");
        String factoryType = scanner.nextLine();
        System.out.print("Enter operation type: ");
        String opeartionType = scanner.nextLine();

        System.out.print("Enter amount: ");
        int amount = scanner.nextInt();
        System.out.print("Enter years: ");
        int years = scanner.nextInt();

        AbstractFactory customerFactory = FactoryProducer.getFactory(factoryType);

        Operation operation;
        if (opeartionType.equalsIgnoreCase("Loan")) {
            operation = customerFactory.getLoan(amount);
            System.out.println(
                    opeartionType + " amount after " + years + " years: " + operation.getTotalCompoundInterest(years));
        } else if (opeartionType.equalsIgnoreCase("Account")) {
            operation = customerFactory.getAccount(amount);
            System.out.println(
                    opeartionType + " amount after " + years + " years: " + operation.getTotalCompoundInterest(years));
        }

        scanner.nextLine();

        System.out.print("Enter customer type: ");
        factoryType = scanner.nextLine();

        customerFactory = FactoryProducer.getFactory(factoryType);

        System.out.print("Enter operation type: ");
        opeartionType = scanner.nextLine();

        System.out.print("Enter amount: ");
        amount = scanner.nextInt();

        System.out.print("Enter years: ");
        years = scanner.nextInt();

        if (opeartionType.equalsIgnoreCase("Loan")) {
            operation = customerFactory.getLoan(amount);
            System.out.println(
                    opeartionType + " amount after " + years + " years: " + operation.getTotalCompoundInterest(years));
        } else if (opeartionType.equalsIgnoreCase("Account")) {
            operation = customerFactory.getAccount(amount);
            System.out.println(
                    opeartionType + " amount after " + years + " years: " + operation.getTotalCompoundInterest(years));
        }
        scanner.close();

    }
}
