package res;

import java.util.ArrayList;
import java.util.List;

// Step 1: Define the Observer interface
interface Observer {
    void update(float temperature);
}

// Step 2: Create the Subject (Observable) class
class WeatherStation {
    private List<Observer> observers = new ArrayList<>();
    private float temperature;

    // Add an observer
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Remove an observer
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // Notify all observers of a temperature change
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }

    // Set a new temperature and notify observers
    public void setTemperature(float temperature) {
        this.temperature = temperature;
        System.out.println("WeatherStation: New temperature set to " + temperature + "°C");
        notifyObservers();
    }
}

// Step 3: Implement Concrete Observers
class PhoneApp implements Observer {
    @Override
    public void update(float temperature) {
        System.out.println("PhoneApp: Weather update received. Temperature is " + temperature + "°C");
    }
}

class DesktopApp implements Observer {
    @Override
    public void update(float temperature) {
        System.out.println("DesktopApp: Weather update received. Temperature is " + temperature + "°C");
    }
}

// Step 4: Client code
public class Obs {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        // Create observers
        Observer phoneApp = new PhoneApp();
        Observer desktopApp = new DesktopApp();

        // Register observers with the subject
        weatherStation.addObserver(phoneApp);
        weatherStation.addObserver(desktopApp);

        // Update temperature, causing observers to receive updates
        weatherStation.setTemperature(25.0f); // Both PhoneApp and DesktopApp receive the update
        weatherStation.setTemperature(30.5f); // Both observers are notified again with the new temperature
    }
}

// TLDR:
// Step-1: Define the Observer interface
// Step-2: Create the Subject (Observable) class
// Step-3: Implement Concrete Observers
// Step-4: Client code : Subject er notifyObservers() method call korle, sob
// ----------------------observer der update() method call hobe
