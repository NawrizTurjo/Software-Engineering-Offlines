package BehavioralPatterns.Onlines.C1;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String stockName, double newPrice);
}

interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}

class Stock implements Subject {
    private String name;
    private double price;
    private List<Observer> observers;

    public Stock(String name, double price) {
        this.name = name;
        this.price = price;
        this.observers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(name, price);
        }
    }
}

class User implements Observer {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockName, double newPrice) {
        System.out.println(name + " has been notified: The price of " + stockName + " is now " + newPrice);
    }
}

public class C1Online {
    public static void main(String[] args) {
        Stock googleStock = new Stock("Google", 1500);
        Stock appleStock = new Stock("Apple", 1200);

        // Create users
        User user1 = new User("Alice");
        User user2 = new User("Bob");

        // Users follow stocks
        googleStock.registerObserver(user1);
        googleStock.registerObserver(user2);
        appleStock.registerObserver(user1);

        // Simulate price changes
        System.out.println("Updating Google stock price...");
        googleStock.setPrice(1550);

        System.out.println("\nUpdating Apple stock price...");
        appleStock.setPrice(1250);

        // User unfollows a stock
        System.out.println("\nBob stops following Google stock...");
        googleStock.removeObserver(user2);

        // Simulate another price change
        System.out.println("\nUpdating Google stock price again...");
        googleStock.setPrice(1600);
    }
}
