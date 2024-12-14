package BehavioralPatterns;

import java.util.ArrayList;
import java.util.List;

// Observer Interface
interface Observer {
    void update(String message);
}

// Subject Interface
interface Subject {
    void attach(Observer observer); // Add an observer

    void detach(Observer observer); // Remove an observer

    void notifyObservers(); // Notify all observers
}

// Concrete Subject
class ConcreteSubject implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private String state;

    // Attach an observer
    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    // Detach an observer
    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    // Notify all observers
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }

    // Set state and notify observers
    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }
}

// Concrete Observer
class ConcreteObserver implements Observer {
    private final String name;

    // Constructor
    public ConcreteObserver(String name) {
        this.name = name;
    }

    // Update method called by the Subject
    @Override
    public void update(String message) {
        System.out.println(name + " received update: " + message);
    }
}

// Client Code
public class ObserverPatternDemo {
    public static void main(String[] args) {
        // Create Subject
        ConcreteSubject subject = new ConcreteSubject();

        // Create Observers
        Observer observer1 = new ConcreteObserver("Observer 1");
        Observer observer2 = new ConcreteObserver("Observer 2");

        // Attach Observers
        subject.attach(observer1);
        subject.attach(observer2);

        // Change state and notify observers
        subject.setState("State Changed to A");
        // Output:
        // Observer 1 received update: State Changed to A
        // Observer 2 received update: State Changed to A

        // Detach one observer
        subject.detach(observer1);

        // Change state and notify observers again
        subject.setState("State Changed to B");
        // Output:
        // Observer 2 received update: State Changed to B
    }
}
