package CreationalPatterns;

import java.util.ArrayList;
import java.util.List;

final class NObjectSingleton {
    // Define how many instances (N) are allowed
    private static final int MAX_INSTANCES = 3;

    // Container for the allowed instances
    private static final List<NObjectSingleton> instances = new ArrayList<>(MAX_INSTANCES);

    // Used to rotate among instances (for round-robin selection)
    private static int nextInstanceIndex = 0;

    // Private constructor prevents external instantiation
    private NObjectSingleton() {
        // Initialize the instance as needed
    }

    // Static block to initialize the N instances once
    static {
        for (int i = 0; i < MAX_INSTANCES; i++) {
            instances.add(new NObjectSingleton());
        }
    }

    // Public method to retrieve an instance in a round-robin fashion
    public static synchronized NObjectSingleton getInstance() {
        NObjectSingleton instance = instances.get(nextInstanceIndex);
        nextInstanceIndex = (nextInstanceIndex + 1) % MAX_INSTANCES;
        return instance;
    }

    // Alternatively, you could provide a method to retrieve an instance by index
    public static NObjectSingleton getInstance(int index) {
        if (index < 0 || index >= MAX_INSTANCES) {
            throw new IllegalArgumentException("Index must be between 0 and " + (MAX_INSTANCES - 1));
        }
        return instances.get(index);
    }

    // Example method to demonstrate instance behavior
    public void doSomething() {
        System.out.println("Instance " + this + " is doing something.");
    }
}

public class SingletonNObjects {
    public static void main(String[] args) {
        // Retrieve instances in a round-robin manner
        for (int i = 0; i < 10; i++) {
            NObjectSingleton instance = NObjectSingleton.getInstance();
            instance.doSomething();
        }
    }
}
