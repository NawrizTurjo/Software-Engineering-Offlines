package CreationalPatterns;

// Abstract Product Interfaces
interface Engine {
    void createEngine();
}

interface Body {
    void createBody();
}

// Concrete Products - Civic
class CivicEngine implements Engine {
    public void createEngine() {
        System.out.println("Creating Civic Engine");
    }
}

class CivicBody implements Body {
    public void createBody() {
        System.out.println("Creating Civic Body");
    }
}

// Concrete Products - Accord
class AccordEngine implements Engine {
    public void createEngine() {
        System.out.println("Creating Accord Engine");
    }
}

class AccordBody implements Body {
    public void createBody() {
        System.out.println("Creating Accord Body");
    }
}

// Abstract Factory Interface
interface CarFactory {
    Engine createEngine();

    Body createBody();
}

// Concrete Factories
class CivicFactory implements CarFactory {
    public Engine createEngine() {
        return new CivicEngine();
    }

    public Body createBody() {
        return new CivicBody();
    }
}

class AccordFactory implements CarFactory {
    public Engine createEngine() {
        return new AccordEngine();
    }

    public Body createBody() {
        return new AccordBody();
    }
}

// Client class that uses the factory
class Car {
    protected Engine engine;
    protected Body body;

    public Car(CarFactory factory) {
        this.engine = factory.createEngine();
        this.body = factory.createBody();
    }

    public void createCar() {
        System.out.println("Creating Car");
    }

    public void assembleCar() {
        createCar();
        engine.createEngine();
        body.createBody();
        System.out.println("Car assembled completely");
    }
}

// Concrete client implementations
// class Civic extends Car {
// public Civic(CarFactory factory) {
// super(factory);
// }

// public void createCar() {
// System.out.println("Creating Civic Car");
// }
// }

// class Accord extends Car {
// public Accord(CarFactory factory) {
// super(factory);
// }

// public void createCar() {
// System.out.println("Creating Accord Car");
// }
// }

// Factory Producer - can be considered a Factory of Factories
// class CarFactoryProducer {
// public static CarFactory getFactory(String carType) {
// if (carType.equalsIgnoreCase("Civic")) {
// return new CivicFactory();
// } else if (carType.equalsIgnoreCase("Accord")) {
// return new AccordFactory();
// }
// return null;
// }
// }

public class CarFactoryMain {
    public static void main(String[] args) {
        // Get the Civic factory
        CarFactory civicFactory = new CivicFactory();

        // Use the factory to create a Civic car
        Car civic = new Car(civicFactory);
        civic.assembleCar();

        System.out.println("\n-----------------------\n");

        // Get the Accord factory
        CarFactory accordFactory = new AccordFactory();

        // Use the factory to create an Accord car
        Car accord = new Car(accordFactory);
        accord.assembleCar();
    }
}