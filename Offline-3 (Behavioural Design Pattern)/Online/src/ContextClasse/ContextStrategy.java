package ContextClasse;

import StratI.iStrategyNotification;

public class ContextStrategy {
    private iStrategyNotification strategy;

    public ContextStrategy(iStrategyNotification strategyNotification) {
        this.strategy= strategyNotification;
    }

    public void changeStrategy(iStrategyNotification newStrat)
    {
        this.strategy = newStrat;
    }

    public void getNotification(String mesasage)
    {
        this.strategy.sendNotification(mesasage);
    }
    public void getTransactionUpdate(String mesasage)
    {
        this.strategy.transactionUpdates(mesasage);
    }
    public void lowBalance(String mesasage)
    {
        this.strategy.lowBalance(mesasage);
    }
    public void promotional(String mesasage)
    {
        this.strategy.promotional(mesasage);
    }

    
}
