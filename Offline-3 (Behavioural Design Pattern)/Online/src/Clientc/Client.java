package Clientc;

import ConcreteStrat.EmailNotification;
import ConcreteStrat.MobileAppNotification;
import ConcreteStrat.SMSNotification;
import ContextClasse.ContextStrategy;
import StratI.iStrategyNotification;

public class Client {
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
