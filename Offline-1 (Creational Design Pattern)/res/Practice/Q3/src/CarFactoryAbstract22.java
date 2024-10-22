// Abstract Product 1: Engine
interface Engine {
    void assemble();
}

// Abstract Product 2: Transmission
interface Transmission {
    void install();
}

// Concrete Product 1: Civic Engine
class CivicEngine implements Engine {
    @Override
    public void assemble() {
        System.out.println("Assembling Civic Engine.");
    }
}

// Concrete Product 2: Accord Engine
class AccordEngine implements Engine {
    @Override
    public void assemble() {
        System.out.println("Assembling Accord Engine.");
    }
}

// Concrete Product 3: Civic Transmission
class CivicTransmission implements Transmission {
    @Override
    public void install() {
        System.out.println("Installing Civic Transmission.");
    }
}

// Concrete Product 4: Accord Transmission
class AccordTransmission implements Transmission {
    @Override
    public void install() {
        System.out.println("Installing Accord Transmission.");
    }
}

// Abstract Factory
interface HondaFactory {
    Engine createEngine();

    Transmission createTransmission();
}

// Concrete Factory 1: Civic Factory
class CivicFactory implements HondaFactory {
    @Override
    public Engine createEngine() {
        return new CivicEngine();
    }

    @Override
    public Transmission createTransmission() {
        return new CivicTransmission();
    }
}

// Concrete Factory 2: Accord Factory
class AccordFactory implements HondaFactory {
    @Override
    public Engine createEngine() {
        return new AccordEngine();
    }

    @Override
    public Transmission createTransmission() {
        return new AccordTransmission();
    }
}

class Car {
    private Engine engine;
    private Transmission transmission;

    public Car(HondaFactory factory) {
        engine = factory.createEngine();
        transmission = factory.createTransmission();
    }

    public void buildCar() {
        engine.assemble();
        transmission.install();
    }
}

public class CarFactoryAbstract22 {

    public static void main(String[] args) {
        // Creating a Civic
        HondaFactory civicFactory = new CivicFactory();
        Car civicClient = new Car(civicFactory);
        civicClient.buildCar();

        System.out.println();

        // Creating an Accord
        HondaFactory accordFactory = new AccordFactory();
        Car accordClient = new Car(accordFactory);
        accordClient.buildCar();
    }
}
