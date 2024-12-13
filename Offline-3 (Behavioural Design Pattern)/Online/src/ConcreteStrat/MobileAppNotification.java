package ConcreteStrat;

import StratI.iStrategyNotification;

public class MobileAppNotification implements iStrategyNotification {

    @Override
    public void sendNotification(String mesasage) {
        System.out.println("Mobile App Notification activated");
    }

    @Override
    public void transactionUpdates(String mesasage) {
        System.out.println("Mobile App Transaction Update: "+mesasage);
    }

    @Override
    public void lowBalance(String mesasage) {
        System.out.println("Mobile App lowbalance warning: "+mesasage);
    }

    @Override
    public void promotional(String mesasage) {
        System.out.println("Mobile App promotional: "+mesasage);
    }
    
}
