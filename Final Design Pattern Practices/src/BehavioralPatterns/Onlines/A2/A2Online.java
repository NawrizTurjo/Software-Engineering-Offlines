package BehavioralPatterns.Onlines.A2;

interface iStrategyNotification {
    public void sendNotification(String mesasage);

    public void transactionUpdates(String mesasage);

    public void lowBalance(String mesasage);

    public void promotional(String mesasage);

}

class ContextStrategy {
    private iStrategyNotification strategy;

    public ContextStrategy(iStrategyNotification strategyNotification) {
        this.strategy = strategyNotification;
    }

    public void changeStrategy(iStrategyNotification newStrat) {
        this.strategy = newStrat;
    }

    public void getNotification(String mesasage) {
        this.strategy.sendNotification(mesasage);
    }

    public void getTransactionUpdate(String mesasage) {
        this.strategy.transactionUpdates(mesasage);
    }

    public void lowBalance(String mesasage) {
        this.strategy.lowBalance(mesasage);
    }

    public void promotional(String mesasage) {
        this.strategy.promotional(mesasage);
    }

}

class SMSNotification implements iStrategyNotification {

    @Override
    public void sendNotification(String mesasage) {
        System.out.println("SMS Notification activated");
    }

    @Override
    public void transactionUpdates(String mesasage) {
        System.out.println("SMS Transaction Update: " + mesasage);
    }

    @Override
    public void lowBalance(String mesasage) {
        System.out.println("SMS lowbalance warning: " + mesasage);
    }

    @Override
    public void promotional(String mesasage) {
        System.out.println("SMS promotional: " + mesasage);
    }

}

class MobileAppNotification implements iStrategyNotification {

    @Override
    public void sendNotification(String mesasage) {
        System.out.println("Mobile App Notification activated");
    }

    @Override
    public void transactionUpdates(String mesasage) {
        System.out.println("Mobile App Transaction Update: " + mesasage);
    }

    @Override
    public void lowBalance(String mesasage) {
        System.out.println("Mobile App lowbalance warning: " + mesasage);
    }

    @Override
    public void promotional(String mesasage) {
        System.out.println("Mobile App promotional: " + mesasage);
    }

}

class EmailNotification implements iStrategyNotification {

    @Override
    public void sendNotification(String mesasage) {
        System.out.println("Email Notification activated");
    }

    @Override
    public void transactionUpdates(String mesasage) {
        System.out.println("Email Transaction Update: " + mesasage);
    }

    @Override
    public void lowBalance(String mesasage) {
        System.out.println("Email lowbalance warning: " + mesasage);
    }

    @Override
    public void promotional(String mesasage) {
        System.out.println("Email promotional: " + mesasage);
    }

}

public class A2Online {
    public static void main(String[] args) {
        iStrategyNotification emailNotification = new EmailNotification();
        iStrategyNotification mobileAppNotification = new MobileAppNotification();
        iStrategyNotification smsNotification = new SMSNotification();

        ContextStrategy contextStrategy = new ContextStrategy(new EmailNotification());
        contextStrategy.getNotification("Hello");

        contextStrategy.changeStrategy(smsNotification);
        contextStrategy.getNotification("Hello");

        contextStrategy.changeStrategy(mobileAppNotification);
        contextStrategy.getTransactionUpdate("Hello");

        contextStrategy.changeStrategy(emailNotification);
        contextStrategy.getTransactionUpdate("Hello");

    }
}
