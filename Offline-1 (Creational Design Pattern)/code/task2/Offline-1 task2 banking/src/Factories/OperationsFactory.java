package Factories;

import AbstractBaseClass.Customer;
import AbstractBaseClass.Operation;
import AbstractFactory.AbstractFactory;

public class OperationsFactory extends AbstractFactory{

    @Override
    public Operation getOperation(String operation) {
        if(operation.equalsIgnoreCase("ACCOUNT")){
            return new Operations.Account();
        }else if(operation.equalsIgnoreCase("LOAN")){
            return new Operations.Loan();
        }else{
            return null;
        }
    }

    @Override
    public Customer getCustomer(String customer) {
        return null;
    }
    
}
