package ConcreteStrat;

import StratI.iStrategyNotification;

public class EmailNotification implements iStrategyNotification{

    @Override
    public void sendNotification(String mesasage) {
        System.out.println("Email Notification activated");
    }

    @Override
    public void transactionUpdates(String mesasage) {
        System.out.println("Email Transaction Update: "+mesasage);
    }

    @Override
    public void lowBalance(String mesasage) {
        System.out.println("Email lowbalance warning: "+mesasage);
    }

    @Override
    public void promotional(String mesasage) {
        System.out.println("Email promotional: "+mesasage);
    }
    
}
