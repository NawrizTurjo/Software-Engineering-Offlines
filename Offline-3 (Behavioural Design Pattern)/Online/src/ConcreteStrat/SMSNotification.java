package ConcreteStrat;

import StratI.iStrategyNotification;

public class SMSNotification implements iStrategyNotification{

    @Override
    public void sendNotification(String mesasage) {
        System.out.println("SMS Notification activated");
    }

    @Override
    public void transactionUpdates(String mesasage) {
        System.out.println("SMS Transaction Update: "+mesasage);
    }

    @Override
    public void lowBalance(String mesasage) {
        System.out.println("SMS lowbalance warning: "+mesasage);
    }

    @Override
    public void promotional(String mesasage) {
        System.out.println("SMS promotional: "+mesasage);
    }
    
}