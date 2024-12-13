package StratI;

public interface iStrategyNotification {
    public void sendNotification(String mesasage);
    public void transactionUpdates(String mesasage);
    public void lowBalance(String mesasage);
    public void promotional(String mesasage);

}
